package org.csystem.app;

import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        for (;;) {
            System.out.print("Bir sayı giriniz:");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            System.out.printf("Text:%s%n", StringUtil.getRandomTextTR(n));
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
