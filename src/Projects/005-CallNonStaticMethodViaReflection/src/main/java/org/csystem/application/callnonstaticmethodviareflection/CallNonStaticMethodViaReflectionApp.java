package org.csystem.application.callnonstaticmethodviareflection;

import org.csystem.util.Console;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public final class CallNonStaticMethodViaReflectionApp {
    private static void callMethod(NonStaticMethodInfo nsmi, int n) throws InvocationTargetException, IllegalAccessException
    {
        Random r = new Random();

        while (n-- > 0) {
            nsmi.addArg(r.nextInt(100));
            nsmi.call();
            nsmi.clearArgs();
        }

        Console.writeLine(nsmi.callToString());
    }

    private static void doWork(String [] args)
    {
        try {
            var nsmi = new NonStaticMethodInfo(args[0], args[1], Object.class);

            callMethod(nsmi, Integer.parseInt(args[2]));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid argument format");
        }
        catch (ClassNotFoundException ignore) {
            Console.Error.writeLine("%s type not found", args[0]);
        }
        catch (NoClassDefFoundError ignore) {
            Console.Error.writeLine("%s type is not appropriate%n", args[0]);
        }
        catch (NoSuchMethodException ex) {
            Console.writeLine("%s method not found", args[1]);
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Exception:%s, Message:%s", ex.getClass().getName(), ex.getMessage());
            Console.writeLine("Unknown exception occured");
        }
    }

    private CallNonStaticMethodViaReflectionApp()
    {
    }

    public static void run(String [] args)
    {
        if (args.length != 3) {
            Console.Error.writeLine("Wrong number of arguments");
            System.exit(-1);
        }
        doWork(args);
    }
}
