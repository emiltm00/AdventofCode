import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class code {

    public static ArrayList<Integer> loadValues(String textLine) {
        ArrayList<Integer> values = new ArrayList<>();
        Scanner scanner = new Scanner(textLine);
        while (scanner.hasNextInt())
            values.add(scanner.nextInt());
        scanner.close();
        return values;
    }

    public static void main(String[] args) {

        String fileName = "/home/emil/AdventofCode/2023/day4/star1/data.txt";
        //String fileName = "/home/emil/AdventofCode/2023/day4/star1/test.txt";
        int sum = 0;
        String textLine;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((textLine = reader.readLine()) != null) {
                String[] textStrings = textLine.split(":");
                textStrings = textStrings[1].split("\\|");
                ArrayList<Integer> values1 = loadValues(textStrings[0]);
                ArrayList<Integer> values2 = loadValues(textStrings[1]);
                int points = 0;
                
                for (Integer i1 : values1) {
                    for (Integer i2 : values2) {
                        if (i1 == i2) {
                            //System.out.println(i1 + " = " + i2);
                            if (points == 0)
                                points = 1;
                            else
                                points = points * 2;
                        }
                    }
                }
                sum += points;
            }
            System.out.println("Result: " + sum);
            reader.close();
        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }
}
