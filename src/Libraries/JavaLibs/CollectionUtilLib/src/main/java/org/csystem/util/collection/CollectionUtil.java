/*----------------------------------------------------------------------
	FILE        : CollectionUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 23.07.2021

	Utility class for collections

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.Collection;
import java.util.HashSet;

public final class CollectionUtil {
    private CollectionUtil()
    {
    }

    public static <T> boolean areAllDistinct(Collection<? extends T> collection)
    {
        return collection.size() == new HashSet<T>(collection).size();
    }
    //...
}
