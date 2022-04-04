/*----------------------------------------------------------------------
	FILE        : DateTimeFormatterUtil.java
	AUTHOR      : Oğuz Karan, JavaApp1-Oct-2021 group
	LAST UPDATE : 22.01.2022

	Utility class for datetime operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.time.format.DateTimeFormatter;

public final class DateTimeFormatterUtil {
    private DateTimeFormatterUtil()
    {}

    public static DateTimeFormatter DATE_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter DATE_DOT_TR = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static DateTimeFormatter DATE_HYPHEN_TR = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static DateTimeFormatter DATETIME_SEC_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
    public static DateTimeFormatter DATETIME_DOT_SEC_TR = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
    public static DateTimeFormatter DATETIME_HYPHEN_SEC_TR = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");

    public static DateTimeFormatter DATETIME_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
    public static DateTimeFormatter DATETIME_DOT_TR = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
    public static DateTimeFormatter DATETIME_HYPHEN_TR = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");

    public static DateTimeFormatter TIME = DateTimeFormatter.ofPattern("hh:mm");
    public static DateTimeFormatter TIME_SEC = DateTimeFormatter.ofPattern("hh:mm:ss");
    //...
}
