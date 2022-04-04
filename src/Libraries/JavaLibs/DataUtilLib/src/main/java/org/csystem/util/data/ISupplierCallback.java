package org.csystem.util.data;

@FunctionalInterface
public interface ISupplierCallback<R> {
    R get() throws Exception;
}
