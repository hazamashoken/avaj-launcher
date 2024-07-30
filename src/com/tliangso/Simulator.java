package com.tliangso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Simulator {

    public static void main(String[] args) {

        if (args.length > 0) {

            try {
                List<String> buffer = readFile(args[0]);
                validateInput(buffer);
                File file = new File("./simulation.txt");
                PrintStream stream = new PrintStream(file);
                System.setOut(stream);
                play(buffer);

            } catch (FileNotFoundException e) {
                System.err.printf("%s: No such file or directory\n", args[0]);
                System.exit(1);
            } catch (InvalidInputException e) {
                System.err.printf("Invalid Input: %s\n", e.getMessage());
                System.exit(1);
            }
        }
    }

    public static void play(List<String> buffer) {
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = AircraftFactory.getInstance();
        while (buffer.get(0).isBlank()) {
            String round = buffer.get(0);
            if (round.isBlank()) {
                buffer.remove(0);
            }
        }
        Integer round_count = Integer.valueOf(buffer.get(0).trim());
        buffer.remove(0);
        ListIterator<String> bufferIt = buffer.listIterator();

        while (bufferIt.hasNext()) {
            String row = bufferIt.next();
            if (row.isEmpty()) {
                continue;
            }
            List<String> attrs = Arrays.asList(row.split("\\s+"));

            ListIterator<String> it = attrs.listIterator();

            List<Integer> coordinate = new ArrayList<Integer>();

            String type = "";
            String name = "";

            while (it.hasNext()) {
                String attr = it.next();
                Integer index = it.nextIndex();
                if (index == 1) {
                    type = attr;

                } else if (index == 2) {
                    name = attr;
                } else if (index >= 3 && index <= 5) {
                    coordinate.add(Integer.valueOf(attr));
                }

            }

            aircraftFactory
                    .newAircraft(type, name, new Coordinates(coordinate.get(0), coordinate.get(1), coordinate.get(2)))
                    .registerTower(weatherTower);

        }
        while (round_count > 0) {
            weatherTower.changeWeather();
            round_count--;
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

    static class InvalidInputException extends Exception {
        public InvalidInputException(String here) {
            super(here);
        }
    }

    public static boolean validateInput(List<String> buffer) throws InvalidInputException {

        while (buffer.get(0).isBlank()) {
            String round = buffer.get(0);
            if (round.isBlank()) {
                buffer.remove(0);
            }
        }

        try {

            Integer round_count = Integer.valueOf(buffer.get(0).trim());

            if (round_count < 1) {
                throw new InvalidInputException("round count must be more than 0: " + round_count);
            }

        } catch (NumberFormatException e) {
            throw new InvalidInputException("invalid round count: " + buffer.get(0));
        }

        List<String> copy = new ArrayList<String>(buffer);

        copy.remove(0);
        ListIterator<String> copyIt = copy.listIterator();

        while (copyIt.hasNext()) {
            String row = copyIt.next();
            if (row.isEmpty()) {
                continue;
            }
            List<String> attrs = Arrays.asList(row.split("\\s+"));

            if (attrs.size() != 5) {
                throw new InvalidInputException(row);
            }

            ListIterator<String> it = attrs.listIterator();
            while (it.hasNext()) {
                String attr = it.next();
                if (it.nextIndex() >= 3 && it.nextIndex() <= 5) {
                    try {

                        Integer.parseInt(attr);

                    } catch (NumberFormatException e) {
                        throw new InvalidInputException(row + ": " + attr);
                    }
                }
            }
        }

        return true;
    }
}
