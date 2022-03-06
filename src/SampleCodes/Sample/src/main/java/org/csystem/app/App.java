/*----------------------------------------------------------------------------------------------------------------------
    deque
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.data.factory.PersonFactory;
import org.csystem.app.data.people.Person;
import org.csystem.util.console.Console;
import org.csystem.util.console.command.CommandLineUtil;

import java.nio.file.Path;
import java.util.stream.Collectors;

class App {
    public static void main(String[] args)
    {
        try {
            CommandLineUtil.checkForLengthEqual(args, 1, "Wrong number of arguments", 1);
            var factory = PersonFactory.loadFromTextFile(Path.of(args[0]));
            var people = factory.PEOPLE;

            var str = people.stream()
                    .map(Person::getName)
                    .map(s -> "[[" + s + "]]")
                    .collect(Collectors.joining(" :: ", "{{", "}}"));

            Console.writeLine(str);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}


