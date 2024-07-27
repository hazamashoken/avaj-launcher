package com.tliangso;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.tliangso.Tower.WeatherTower;

public class Simulator {

    public static void main(String[] args) {

        if (args.length > 0) {

            int round = 0;
            WeatherTower weatherTower = new WeatherTower();

            try {
                List<String> buffer = readFile(args[0]);

                validateInput(buffer);



            } catch (FileNotFoundException e) {
                System.err.printf("%s: No such file or directory", args[0]);
            }
        }
    }

    public static List<String> readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);

        List<String> buffer = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            buffer.add(fileScanner.nextLine());
        }

        fileScanner.close();

        return buffer;
    }

    public static boolean validateInput(List<String> buffer) {

        Consumer<String> checkFlyablConsumer = new Consumer<String>() {
            public void accept(String row) {
    
            };
        };
        
        try {
            String round = buffer.get(0);
            int round_count =  Integer.valueOf(round);

            System.out.printf("Round count %d\n", round_count);

            List<String> copy = new ArrayList<String>(buffer);

            copy.remove(0);

            copy.forEach(checkFlyablConsumer);


        } catch (NumberFormatException e) {
            System.err.println("Invalid Format !");
        }

        return true;
    }
}
