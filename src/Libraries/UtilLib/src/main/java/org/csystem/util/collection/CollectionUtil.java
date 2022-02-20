/*----------------------------------------------------------------------
	FILE        : CollectionUtil.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 20.02.2022

	Utility class for collections

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.Collection;
import java.util.HashSet;

public final class CollectionUtil {
    private CollectionUtil()
    {}

    public static <T> boolean areAllDistinct(Collection<? extends T> collection)
    {
        return collection.size() == new HashSet<>(collection).size();
    }
}
