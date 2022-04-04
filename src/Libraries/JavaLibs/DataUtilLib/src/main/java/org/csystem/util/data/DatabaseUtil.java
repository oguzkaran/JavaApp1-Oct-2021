package org.csystem.util.data;

import org.csystem.util.data.repository.RepositoryException;
import org.csystem.util.data.service.DataServiceException;

import java.util.function.Consumer;

public final class DatabaseUtil {
    private DatabaseUtil()
    {}

    public static <R> R doWorkForRepository(ISupplierCallback<R> supplier, String msg)
    {
        try {
            return supplier.get();
        }
        catch (Throwable ex) {
            throw new RepositoryException(msg, ex);
        }
    }

    public static <R> R doWorkForRepository(ISupplierCallback<R> supplier, Consumer<Throwable> consumer, String msg)
    {
        try {
            return supplier.get();
        }
        catch (Throwable ex) {
            consumer.accept(ex);
            throw new RepositoryException(msg, ex);
        }
    }

    public static void doWorkForRepositoryRunnable(IActionCallback action, String msg)
    {
        try {
            action.run();
        }
        catch (Throwable ex) {
            throw new RepositoryException(msg, ex);
        }
    }

    public static void doWorkForRepositoryRunnable(IActionCallback action, Consumer<Throwable> consumer, String msg)
    {
        try {
            action.run();
        }
        catch (Throwable ex) {
            consumer.accept(ex);
            throw new RepositoryException(msg, ex);
        }
    }

    public static <R> R doWorkForService(ISupplierCallback<R> supplier, String msg)
    {
        try {
            return supplier.get();
        }
        catch (RepositoryException ex) {
            throw new DataServiceException(msg, ex.getCause());
        }
        catch (Throwable ex) {
            throw new DataServiceException(msg, ex);
        }
    }

    public static <R> R doWorkForService(ISupplierCallback<R> supplier, Consumer<Throwable> consumer, String msg)
    {
        try {
            return supplier.get();
        }
        catch (RepositoryException ex) {
            consumer.accept(ex);
            throw new DataServiceException(msg, ex.getCause());
        }
        catch (Throwable ex) {
            throw new DataServiceException(msg, ex);
        }
    }

    public static void doWorkForServiceRunnable(IActionCallback runnable, String msg)
    {
        try {
            runnable.run();
        }
        catch (RepositoryException ex) {
            throw new DataServiceException(msg, ex.getCause());
        }
        catch (Throwable ex) {
            throw new DataServiceException(msg, ex);
        }
    }

    public static void doWorkForServiceRunnable(IActionCallback runnable, Consumer<Throwable> consumer, String msg)
    {
        try {
            runnable.run();
        }
        catch (RepositoryException ex) {
            consumer.accept(ex);
            throw new DataServiceException(msg, ex.getCause());
        }
        catch (Throwable ex) {
            consumer.accept(ex);
            throw new DataServiceException(msg, ex);
        }
    }
}
