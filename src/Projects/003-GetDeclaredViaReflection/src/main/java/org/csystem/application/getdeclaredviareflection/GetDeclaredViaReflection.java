package org.csystem.application.getdeclaredviareflection;

import org.csystem.util.Console;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public final class GetDeclaredViaReflection {
    private static void printMetadata(Class<?> cls)
    {
        Console.writeLine("------------------------------------");

        Console.writeLine("Declared fields:");
        for (Field field : cls.getDeclaredFields())
            Console.writeLine("Type:%s, Name=%s", field.getType().getName(), field.getName());

        Console.writeLine("------------------------------------");
        Console.writeLine("Declared methods:");
        for (Method method : cls.getDeclaredMethods()) {
            Console.write("%s %s(", method.getReturnType().getSimpleName(), method.getName());
            StringBuilder parameters = new StringBuilder();
            for (Parameter parameter : method.getParameters())
                parameters.append(String.format("%s %s, ", parameter.getType().getSimpleName(), parameter.getName()));

            if (parameters.length() != 0)
                Console.writeLine("%s)", parameters.substring(0, parameters.length() - 2));
            else
                Console.writeLine(")");
        }
        Console.writeLine("------------------------------------");

        Console.writeLine("Declared Constructors");
        for (Constructor<?> ctor : cls.getDeclaredConstructors()) {
            Console.write("%s(", ctor.getName());
            StringBuilder parameters = new StringBuilder();
            for (Parameter parameter : ctor.getParameters())
                parameters.append(String.format("%s %s, ", parameter.getType().getSimpleName(), parameter.getName()));
            if (parameters.length() != 0)
                Console.writeLine("%s)", parameters.substring(0, parameters.length() - 2));
            else
                Console.writeLine(")");
        }
        Console.writeLine("------------------------------------");

        Console.writeLine("Declared Annotations");
        for (Annotation annotation : cls.getDeclaredAnnotations()) {
            Class<?> clsAnnotation = annotation.annotationType();

            for (Method attr : clsAnnotation.getDeclaredMethods())
                Console.write("%s %s()", attr.getReturnType().getSimpleName(), attr.getName());
        }

        Console.writeLine("------------------------------------");
        Console.writeLine("Declared Interfaces");
        for (Class<?> clsInterface : cls.getInterfaces())
            Console.writeLine("%s", clsInterface.getName());

        Console.writeLine("------------------------------------");
    }

    private static void doWork(String [] args)
    {
        for (String typeName : args) {
            try {
                Class<?> cls = Class.forName(typeName);

                Console.writeLine("%s byte code is found", typeName);
                printMetadata(cls);
            }
            catch (ClassNotFoundException ignore) {
                Console.Error.writeLine("%s type not found", typeName);
            }
            catch (NoClassDefFoundError ignore) {
                Console.Error.writeLine("%s type is not appropriate%n", typeName);
            }
            catch (Throwable ex) {
                Console.Error.writeLine("Exception Message:%s", ex.getMessage());
                Console.writeLine("Unknown exception occured");
            }
        }
    }

    private GetDeclaredViaReflection()
    {
    }

    public static void run(String [] args)
    {
        if (args.length == 0) {
            Console.Error.writeLine("Wrong number of arguments");
            System.exit(-1);
        }
        doWork(args);
    }
}
