package org.csystem.app.reflection;

import org.csystem.util.console.Console;
import org.csystem.util.console.command.CommandLineUtil;
import org.csystem.util.numeric.NumberUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public final class CallNonStaticMethodViaReflectionApp {
    private CallNonStaticMethodViaReflectionApp()
    {
    }

    private static void callMethod(NonStaticMethodInfo nsmi, int n) throws InvocationTargetException, IllegalAccessException
    {
        Random r = new Random();

        while (n-- > 0) {
            nsmi.addArg(r.nextInt(100));
            nsmi.call();
            nsmi.clearArgs();
        }
    }

    private static void doCallCallback(String [] args, int n)
    {
        try {
            var nsmi = new NonStaticMethodInfo(args[0], args[1], Object.class);

            callMethod(nsmi, n);
        }
        catch (ClassNotFoundException ignore) {
            Console.Error.writeLine("%s type not found", args[0]);
        }
        catch (NoSuchMethodException ignore) {
            Console.Error.writeLine("%s method not found", args[1]);
        }
        catch (InvocationTargetException|InstantiationException  e) {
            Console.Error.writeLine("No available default ctor found");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Exception:%s, Message:%s", ex.getClass().getName(), ex.getMessage());
            Console.Error.writeLine("Unknown exception occurred");
        }
    }

    private static void doCall(String [] args)
    {
        NumberUtil.toInt(args[2]).ifPresentOrElse(n -> doCallCallback(args, n), () -> Console.Error.writeLine("Invalid Arguments"));
    }

    public static void run(String [] args)
    {
        CommandLineUtil.checkForLengthLess(args, 3, "Wrong number of arguments", 1);
        doCall(args);
    }
}
