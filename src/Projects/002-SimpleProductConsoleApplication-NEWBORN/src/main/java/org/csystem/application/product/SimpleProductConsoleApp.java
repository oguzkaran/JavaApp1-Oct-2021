package org.csystem.application.product;

public class SimpleProductConsoleApp {
    private SimpleProductConsoleApp()
    {
    }

    public static void run()
    {
        SimpleProductConsoleAppMenu menu = new SimpleProductConsoleAppMenu();

        menu.run();
    }
}
