import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day1_2 {

    public static String modifyDigits(String textLine) {
        //textLine = "6threexgtvlxthree5fiveseven";
        textLine = textLine.replace("one", "o1e");
        textLine = textLine.replace("two", "t2o");
        textLine = textLine.replace("three", "t3e");
        textLine = textLine.replace("four", "f4");
        textLine = textLine.replace("five", "f5e");
        textLine = textLine.replace("six", "6");
        textLine = textLine.replace("seven", "s7n");
        textLine = textLine.replace("eight", "e8t");
        textLine = textLine.replace("nine", "n9e");   
        
        System.out.print(textLine + ": ");

        return textLine;
    }

    public static int findNummer(String textLine) {
        int firstDigit = -1;
        int lastDigit = -1;

        // Modify to real digits
        textLine = modifyDigits(textLine);

        // Find first
        for (int i = 0; i < textLine.length(); i++) {
            if (Character.isDigit(textLine.charAt(i))) {
                firstDigit = Character.getNumericValue(textLine.charAt(i));
                break;
            }
        }

        // Find last
        for (int i = textLine.length() - 1; i >= 0; i--) {
            if (Character.isDigit(textLine.charAt(i))) {
                lastDigit = Character.getNumericValue(textLine.charAt(i));
                break;
            }
        }
        System.out.println(firstDigit*10 + lastDigit);
        return firstDigit*10 + lastDigit;
    }
    public static void main(String[] args) {
        String fileName = "data.txt";
        int totalSum = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String textLine;
            while ((textLine = reader.readLine()) != null) {
                totalSum += findNummer(textLine);
            }
            System.out.println("Total Sum: " + totalSum);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
