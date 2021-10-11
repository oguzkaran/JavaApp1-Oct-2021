/*----------------------------------------------------------------------
	FILE        : CommandPrompt.java
	AUTHOR      : CSD Project Group
	LAST UPDATE : 24.06.2021

	CommandPrompt class which manages commands

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.commandprompt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommandPrompt {
    private final Scanner m_kb = new Scanner(System.in);
    private Object m_regObject;
    private final ArrayList<MethodCallInfo> m_methodCallInfos = new ArrayList<>();
    private Method m_errorMethod;
    private String m_prompt = "csd";
    private String m_promptSuffix = ">";
    private String m_paramStringTypeErrorMessage = "Method parameters must be String";
    private String m_wrongNumberOfArgumentsMessage = "Wrong number of arguments";
    private String m_invalidCommandMessage = "Invalid Command";

    private static class MethodCallInfo {
        String commandText;
        Method method;
        int argCount;

        public MethodCallInfo(String commandText, Method method, int argCount)
        {
            this.commandText = commandText;
            this.method = method;
            this.argCount = argCount;
        }
    }

    public static boolean areAllString(Parameter [] parameters)
    {
        for (Parameter parameter : parameters)
            if (parameter.getParameterizedType() != String.class)
                return false;

        return true;
    }

    private void registerCommands(Command [] commands, Method method)
    {
        for (Command command : commands) {
            String value = command.value();
            String commandText = value.isBlank() ? method.getName() : value;

            Parameter [] parameters = method.getParameters();

            if (!areAllString(parameters))
                throw new IllegalArgumentException(m_paramStringTypeErrorMessage);

            m_methodCallInfos.add(new MethodCallInfo(commandText, method, parameters.length));
        }
    }

    public void runCommands(String [] args, String [] params) throws InvocationTargetException, IllegalAccessException
    {
        boolean flag = false;
        boolean argsFlag = false;

        for (MethodCallInfo methodCallInfo : m_methodCallInfos) {
            if (methodCallInfo.commandText.equals(args[0])) {
                flag = true;
                argsFlag = true;
                if (methodCallInfo.argCount != params.length) {
                    argsFlag = false;
                    continue;
                }
                methodCallInfo.method.setAccessible(true);
                methodCallInfo.method.invoke(m_regObject, (Object[])params);
                methodCallInfo.method.setAccessible(false);
                break;
            }
        }
        if (!flag) {
            if (m_errorMethod != null) {
                m_errorMethod.setAccessible(true);
                m_errorMethod.invoke(m_regObject);
                m_errorMethod.setAccessible(false);
            }
            else
                System.err.println(m_invalidCommandMessage);
        }
        else if (!argsFlag) {
            System.err.println(m_wrongNumberOfArgumentsMessage);
        }
    }

    public String getPrompt()
    {
        return m_prompt;
    }

    public String getPromptSuffix()
    {
        return m_promptSuffix;
    }

    public String getParamStringTypeErrorMessage()
    {
        return m_paramStringTypeErrorMessage;
    }

    public String getWrongNumberOfArgumentsMessage()
    {
        return m_wrongNumberOfArgumentsMessage;
    }

    public String getInvalidCommandMessage()
    {
        return m_invalidCommandMessage;
    }

    public CommandPrompt setPrompt(String prompt)
    {
        m_prompt = prompt;

        return this;
    }

    public CommandPrompt setPromptSuffix(String promptSuffix)
    {
        m_promptSuffix = promptSuffix;

        return this;
    }

    public CommandPrompt setParamStringTypeErrorMessage(String paramStringTypeErrorMessage)
    {
        m_paramStringTypeErrorMessage = paramStringTypeErrorMessage;

        return this;
    }

    public CommandPrompt setWrongNumberOfArgumentsMessage(String wrongNumberOfArgumentsMessage)
    {
        m_wrongNumberOfArgumentsMessage = wrongNumberOfArgumentsMessage;

        return this;
    }

    public CommandPrompt setInvalidCommandMessage(String invalidCommandMessage)
    {
        m_invalidCommandMessage = invalidCommandMessage;

        return this;
    }

    public CommandPrompt register(Object regObject)
    {
        m_regObject = regObject;
        Class<?> regObjectClass = m_regObject.getClass();
        Method [] methods = regObjectClass.getDeclaredMethods();

        for (Method method : methods) {
            Command[] commands = method.getAnnotationsByType(Command.class);

            if (commands.length == 0) {
                if (m_errorMethod == null && method.getDeclaredAnnotation(ErrorCommand.class) != null
                        && method.getParameters().length == 0)
                    m_errorMethod = method;
                continue;
            }
            registerCommands(commands, method);
        }

        return this;
    }

    public void run()
    {
        try {
            for (;;) {
                System.out.print(m_prompt + m_promptSuffix);
                String cmd = m_kb.nextLine().strip();

                if (cmd.isEmpty())
                    continue;

                String [] args = cmd.split("[ \t]+");
                String [] params = Arrays.copyOfRange(args, 1, args.length);

                runCommands(args, params);
            }
        }
        catch (Throwable ex) {
            ex.printStackTrace();
            throw new IllegalStateException(ex.getMessage(), ex);

        }
    }
}
