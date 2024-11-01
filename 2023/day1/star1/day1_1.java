import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day1_1 {

    public static int findNummer(String textLine) {
        int firstDigit = -1;
        int lastDigit = -1;

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
