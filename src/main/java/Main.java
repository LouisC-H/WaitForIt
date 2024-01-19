import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        try {
//            File myObj = new File("src/main/resources/test.txt");
            File myObj = new File("src/main/resources/input.txt");
            Scanner myReader = new Scanner(myObj);
            String timeData = myReader.nextLine();
            String distanceData = myReader.nextLine();
//            simulateRaces(timeData, distanceData);
            simulateBigRace(timeData, distanceData);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void simulateRaces(String timeData, String distanceData) {
        int[] parsedTimes = parseRacesData(timeData);
        int[] parsedDistances = parseRacesData(distanceData);

        int rollingMultiple = 1;
        Race[] racesList = new Race[parsedTimes.length];
        for (int i = 0; i < parsedTimes.length; i++) {
            racesList[i] = new Race(parsedTimes[i], parsedDistances[i]);
            rollingMultiple *= racesList[i].getNumWaysToWin();
        }
        System.out.println(rollingMultiple);
    }

    private static int[] parseRacesData(String inputData) {
        String[] headerAndData = inputData.split(":");
        String[] strData = headerAndData[1].split(" +");
        int[] parsedData = new int[strData.length-1];
        for (int i = 1; i < strData.length; i++) {
            parsedData[i-1] = Integer.parseInt(strData[i]);
        }
        return parsedData;
    }

    private static void simulateBigRace(String timeData, String distanceData) {
        long parsedTimes = parseBigRaceData(timeData);
        long parsedDistances = parseBigRaceData(distanceData);

        Race bigRace = new Race(parsedTimes, parsedDistances);
        System.out.println(bigRace.getNumWaysToWin());
    }

    private static long parseBigRaceData(String inputData) {
        String[] headerAndData = inputData.split(":");
        String[] strData = headerAndData[1].split(" +");
        StringBuilder parsedData = new StringBuilder();
        for (int i = 1; i < strData.length; i++) {
            parsedData.append(strData[i]);
        }
        return Long.parseLong(parsedData.toString());
    }
}
