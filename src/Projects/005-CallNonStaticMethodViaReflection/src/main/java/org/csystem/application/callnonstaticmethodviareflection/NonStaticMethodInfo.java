package org.csystem.application.callnonstaticmethodviareflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class NonStaticMethodInfo {
    private final Method m_method;
    private final ArrayList<Object> m_arguments = new ArrayList<>();
    private final Object m_object;

    public NonStaticMethodInfo(String typeName, String methodName, Class<?>...paramTypes)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
                    InstantiationException, IllegalAccessException
    {
        Class<?> cls = Class.forName(typeName);
        m_method = cls.getMethod(methodName, paramTypes);
        Constructor<?> defaultCtor = cls.getDeclaredConstructor();

        defaultCtor.setAccessible(true);
        m_object = defaultCtor.newInstance();
        defaultCtor.setAccessible(false);
    }

    public void addArg(Object arg)
    {
        addArgs(arg);
    }

    public void clearArgs()
    {
        m_arguments.clear();
    }

    public void addArgs(Object...args)
    {
        for (var o : args)
            m_arguments.add(o);
    }

    public void call() throws InvocationTargetException, IllegalAccessException
    {
        m_method.invoke(m_object, m_arguments.toArray(new Object[0]));
    }

    public String callToString()
    {
        return m_object.toString();
    }
}
