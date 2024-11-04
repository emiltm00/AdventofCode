import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class code {
    /*
     * Find the fewest amount of cubes for all the colors to make the game possible.
     * calculate the power of each game by multiplying the least needed colors by eachother
     * add the sums of all the powers of those games.
     */

     // Check if possible
    public static int calcPower(String textLine) {
        int needRed = 0;
        int needGreen = 0;
        int needBlue = 0;

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
                        if (number > needRed) needRed = number;
                        break;
                    case "green":
                        if (number > needGreen) needGreen = number;
                        break;
                    case "blue":
                        if (number > needBlue) needBlue = number;
                        break;
                }
            }
        }
        return needRed * needGreen * needBlue;
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
                totalSum += calcPower(textLine);
            }
            System.out.println("\nTotal Sum: " + totalSum);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
