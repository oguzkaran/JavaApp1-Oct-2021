package org.csystem.app.plugin;

import org.csystem.util.console.Console;

import java.util.ArrayList;
import java.util.Collections;

public class SamplePlugin {
    private final ArrayList<String> m_types = new ArrayList<>();

    public SamplePlugin(String...types)
    {
        Collections.addAll(m_types, types);
    }

    public void run()
    {
        for (var s : m_types) {
            try {
                var cls = Class.forName(s);
                Console.writeLine(cls.getSimpleName());
            }
            catch (ClassNotFoundException ignored) {
                Console.Error.writeLine("%s type not found", s);
            }
        }
    }
}
