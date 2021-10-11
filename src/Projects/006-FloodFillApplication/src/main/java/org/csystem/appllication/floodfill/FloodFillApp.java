package org.csystem.appllication.floodfill;

import org.csystem.util.image.AsciiImage;

public final class FloodFillApp {
    private FloodFillApp()
    {}

    public static void run(String [] args)
    {
        if (args.length != 4) {
            System.err.println("Wrong number of arguments");
            System.exit(1);
        }
        try {
            AsciiImage asciiImage = new AsciiImage(Integer.parseUnsignedInt(args[0]), Integer.parseUnsignedInt(args[1]));

            asciiImage.loadImage(args[2]);
            System.out.println(asciiImage);
            asciiImage.floodFill(4, 4, '.', '#');
            System.out.println("////////////////////////////////////////////////////////////////////////");
            System.out.println(asciiImage);
            asciiImage.saveImage(args[3]);
        }
        catch (NumberFormatException ignore) {
            System.err.println("Invalid width/height value");
        }
        catch (Throwable ex) {
            System.err.printf("Unknown problem occured:%s", ex.getMessage());
        }
    }
}
