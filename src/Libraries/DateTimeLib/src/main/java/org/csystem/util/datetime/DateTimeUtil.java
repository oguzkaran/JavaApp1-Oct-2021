/*----------------------------------------------------------------------
	FILE        : DateTimeUtil.java
	AUTHOR      : Oğuz Karan, JavaApp1-Oct-2021 group
	LAST UPDATE : 13.11.2020

	Utility class for datetime operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.time.format.DateTimeFormatter;

public final class DateTimeUtil {
    private DateTimeUtil()
    {}

    public static DateTimeFormatter DATE_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter DATE_DOT_TR = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static DateTimeFormatter DATE_HYPHEN_TR = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //...
}
