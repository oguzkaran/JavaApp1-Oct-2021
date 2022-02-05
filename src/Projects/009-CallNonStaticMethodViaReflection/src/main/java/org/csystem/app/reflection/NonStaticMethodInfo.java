package org.csystem.app.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class NonStaticMethodInfo {
    private final Method m_method;
    private final ArrayList<Object> m_arguments;
    private final Object m_object;

    public NonStaticMethodInfo(String typeName, String methodName, Class<?>...paramTypes)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        var cls = Class.forName(typeName);
        var defaultCtor = cls.getDeclaredConstructor();

        m_method = cls.getMethod(methodName, paramTypes);
        defaultCtor.setAccessible(true);
        m_object = defaultCtor.newInstance();
        defaultCtor.setAccessible(false);
        m_arguments = new ArrayList<>();
    }

    public void addArg(Object arg)
    {
        addArgs(arg);
    }

    public void addArgs(Object...args)
    {
        Collections.addAll(m_arguments, args);
    }

    public void clearArgs()
    {
        m_arguments.clear();
    }

    public void call() throws InvocationTargetException, IllegalAccessException
    {
        m_method.invoke(m_object, m_arguments.toArray(new Object[0]));
    }
}
