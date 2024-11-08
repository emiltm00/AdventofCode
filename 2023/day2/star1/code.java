import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class code {
    /*
     * Which games would have been possible with only 12 red, 13 green, and 14 blue
     * cubes.
     * add the sums of the IDs of those games.
     */

     // Check if possible
    public static boolean ifPossible(String textLine) {
        int defaultRed = 12;
        int defaultGreen = 13;
        int defaultBlue = 14;
        boolean possibleGame = true;

        String[] gameString = textLine.split(":");
        String[] cubesOneShow = gameString[1].split(";");
   
        for (String cubesOneShowString : cubesOneShow) {
            String[] amountColorCube = cubesOneShowString.split(",");
            for (String amountColorCubeString : amountColorCube) {
                String[] eachNumber = amountColorCubeString.split(" ");
                int number = Integer.parseInt(eachNumber[1]);
                String color = eachNumber[2];

                switch (color) {
                    case "red":
                        if (number > defaultRed) possibleGame = false;
                        break;
                    case "green":
                        if (number > defaultGreen) possibleGame = false;
                        break;
                    case "blue":
                        if (number > defaultBlue) possibleGame = false;
                        break;
                }
            }
        }
        return possibleGame;
    }

    // Get game ID
    public static int gameID(String textLine) {
        String[] gameString = textLine.split(":");
        String[] idString = gameString[0].split(" ");
        System.out.println("Valid Game: " + idString[1]);

        return  Integer.parseInt(idString[1]);
    }
    public static void main(String[] args) {
        String fileName = "/home/emil/AdventofCode/2023/day2/star1/data.txt";
        int totalSum = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String textLine;
            while ((textLine = reader.readLine()) != null) {
                if (ifPossible(textLine)) {
                    totalSum += gameID(textLine);
                }
            }
            System.out.println("\nTotal Sum: " + totalSum);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
