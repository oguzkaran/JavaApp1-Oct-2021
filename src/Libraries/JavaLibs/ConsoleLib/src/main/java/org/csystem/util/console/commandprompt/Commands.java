/*----------------------------------------------------------------------
	FILE        : Command.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 06.02.2022

	Annotation that is for CommandPrompt

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.console.commandprompt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Commands {
    Command[] value();
}
