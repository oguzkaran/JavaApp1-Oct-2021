/*----------------------------------------------------------------------------------------------------------------------
    Basit bir dijital saat uygulaması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        var prompt = Console.read("Mesajı giriniz:");

        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run()
            {
                Console.write("%s:%s\r", prompt, DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(LocalDateTime.now()));
            }
        }, 0, 1000);
    }
}

