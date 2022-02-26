package org.csystem.app.data.camera;

import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.*;

public class CarCamInfoSimulationApp {
    private CarCamInfoSimulationApp()
    {}

    public static void run()
    {
        var carMap = new TreeMap<String, List<CarCamInfo>>(Comparator.reverseOrder());
        var count = Console.readInt("Araba sayısını giriniz:");

        var random = new Random();
        var factory = new RandomCarCamFactory(random);

        for (int i = 0; i < count; ++i) {
            Console.write(".");
            var ci = factory.getCarCamInfo();

            if (!carMap.containsKey(ci.getPlate())) {
                var list = new ArrayList<CarCamInfo>();

                list.add(ci);
                carMap.put(ci.getPlate(), list);
            }
            else
                carMap.get(ci.getPlate()).add(ci);

            ThreadUtil.sleep(random.nextInt(300) + 100);
        }

        Console.writeLine("\nAraba geçiş bilgileri:");
        for (var p : carMap.keySet()) {
            Console.write("%s:", p);
            for (var ci : carMap.get(p))
                Console.write("%s ", ci);

            Console.writeLine();
        }
    }
}
