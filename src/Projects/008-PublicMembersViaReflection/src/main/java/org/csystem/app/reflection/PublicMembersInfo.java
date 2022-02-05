package org.csystem.app.reflection;

import org.csystem.util.console.Console;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;

public class PublicMembersInfo {
    private final ArrayList<String> m_types = new ArrayList<>();

    private void printPublicFields(Class<?> cls)
    {
        Console.writeLine("-----------------------------------------------");
        Console.writeLine("Public Fields:");
        for (var field : cls.getFields())
            Console.writeLine("Type:%s, Name:%s", field.getType().getName(), field.getName());
        Console.writeLine("-----------------------------------------------");
    }

    private void printPublicMethods(Class<?> cls)
    {
        Console.writeLine("-----------------------------------------------");
        Console.writeLine("Public Methods:");
        for (var method : cls.getMethods()) {
            Console.write("%s %s(", method.getReturnType().getSimpleName(), method.getName());
            printParameters(method.getParameters());
        }
        Console.writeLine("-----------------------------------------------");
    }

    private void printPublicConstructors(Class<?> cls)
    {
        Console.writeLine("-----------------------------------------------");
        Console.writeLine("Constructors:");
        for (var ctor : cls.getConstructors()) {
            Console.write("%s(", ctor.getName());
            printParameters(ctor.getParameters());
        }
        Console.writeLine("-----------------------------------------------");
    }

    private void printParameters(Parameter[] parameters)
    {
        var params = new StringBuilder();

        for (var param : parameters)
            params.append(String.format("%s %s, ", param.getType().getSimpleName(), param.getName()));

        if (params.length() != 0)
            Console.write("%s", params.substring(0, params.length() - 2));

        Console.writeLine(");");
    }

    private void printInterfaces(Class<?> cls)
    {
        Console.writeLine("-----------------------------------------------");
        Console.writeLine("Interfaces:");
        for (var clsInterface : cls.getInterfaces())
            Console.writeLine(clsInterface.getName());
        Console.writeLine("-----------------------------------------------");
    }

    private void printAnnotations(Class<?> cls)
    {
        Console.writeLine("-----------------------------------------------");
        Console.writeLine("Annotations:");
        for (var annotation : cls.getAnnotations()) {
            var clsAnnotation = annotation.annotationType();
            Console.writeLine("Name:%s", clsAnnotation.getName());

            for (var attr : clsAnnotation.getMethods())
                Console.writeLine("%s %s()", attr.getReturnType().getSimpleName(), attr.getName());
        }
        Console.writeLine("-----------------------------------------------");
    }

    private void printPublicMembers(Class<?> cls)
    {
        Console.writeLine("Public Members:");
        printPublicFields(cls);
        printPublicMethods(cls);
        printPublicConstructors(cls);
        printInterfaces(cls);
        printAnnotations(cls);
    }

    public PublicMembersInfo(String...types)
    {
        Collections.addAll(m_types, types);
    }

    public void run()
    {
        for (var typeName : m_types) {
            try {
                var cls = Class.forName(typeName);
                Console.writeLine("%s byte code found", cls.getName());
                Console.writeLine("#####################################################");
                printPublicMembers(cls);
                Console.writeLine("#####################################################");
            }
            catch (ClassNotFoundException ignore) {
                Console.Error.writeLine("%s type not found", typeName);
            }
            catch (NoClassDefFoundError ignore) {
                Console.Error.writeLine("%s is not appropriate", typeName);
            }
            catch (Throwable ex) {
                Console.Error.writeLine("Exception message:%s", ex.getMessage());
                Console.Error.writeLine("Unknown error occurs");
            }
        }
    }
}
