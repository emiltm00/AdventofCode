import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class code {

    public static void printMatrix(char[][] matrix) {
        // Print matrix
        for (char[] column : matrix) {
            System.out.print('[');
            System.out.print(column[0] + ",");
            for (int rows = 0; rows < column.length - 2; rows++) {
                System.out.print(column[rows] + ",");
            }
            System.out.print(column[column.length - 1]);
            System.out.println(']');
        }
    }

    public static void main(String[] args) {
        String fileName = "/home/emil/AdventofCode/2023/day3/star1/data.txt";
        //String fileName = "/home/emil/AdventofCode/2023/day3/star1/test.txt";
        int row = 140;
        int col = 140;
        char[][] matrix = new char[row][col];
        int totalSum = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String textLine;
            int r = 0;
            while ((textLine = reader.readLine()) != null) {
                for (int c = 0; c < col; c++) {
                    matrix[r][c] = textLine.charAt(c);
                }
                r++;
            }

            // Find symbols and check numbers around it
            for (int index_r = 0; index_r < col; index_r++) {
                for (int index_c = 0; index_c < col; index_c++) {
                    char currentChar = matrix[index_r][index_c];
                    if (!Character.isDigit(currentChar) && currentChar != '.') {

                        // Find number on line over
                        for (int incrementColumnIndex = index_c - 1; incrementColumnIndex <= index_c + 1; incrementColumnIndex++) {
                            if (Character.isDigit(matrix[index_r - 1][incrementColumnIndex])) {

                                // Find the first number in the sequence
                                char seekingChar = matrix[index_r - 1][incrementColumnIndex];
                                int seekingColumn = incrementColumnIndex;
                                while (seekingColumn > 0 && Character.isDigit(matrix[index_r - 1][seekingColumn - 1])) {
                                    seekingChar = matrix[index_r - 1][seekingColumn - 1];
                                    seekingColumn--;
                                }
                                // Find the whole number
                                String numberString = "";
                                while (seekingColumn < col && Character.isDigit(matrix[index_r - 1][seekingColumn])) {
                                    seekingChar = matrix[index_r - 1][seekingColumn];
                                    seekingColumn++;
                                    numberString += seekingChar;
                                }
                                incrementColumnIndex = seekingColumn;
                                totalSum += Integer.parseInt(numberString);
                            }
                        }

                        // Find number on left side
                        if (index_c > 0 && Character.isDigit(matrix[index_r][index_c - 1])) {
                            // Find the first number in the sequence
                            char seekingChar = matrix[index_r][index_c - 1];
                            int seekingColumn = index_c - 1;
                            while (seekingColumn > 0 && Character.isDigit(matrix[index_r][seekingColumn - 1])) {
                                seekingChar = matrix[index_r][seekingColumn - 1];
                                seekingColumn--;
                            }
                            // Find the whole number
                            String numberString = "";
                            while (seekingColumn < col && Character.isDigit(matrix[index_r][seekingColumn])) {
                                seekingChar = matrix[index_r][seekingColumn];
                                seekingColumn++;
                                numberString += seekingChar;
                            }
                            totalSum += Integer.parseInt(numberString);
                        }
                        // Find number on right side
                        if (index_c < col - 1 && Character.isDigit(matrix[index_r][index_c + 1])) {
                            // Find the first number in the sequence
                            char seekingChar = matrix[index_r][index_c + 1];
                            int seekingColumn = index_c + 1;
                            while (seekingColumn > 0 && Character.isDigit(matrix[index_r][seekingColumn - 1])) {
                                seekingChar = matrix[index_r][seekingColumn - 1];
                                seekingColumn--;
                            }
                            // Find the whole number
                            String numberString = "";
                            while (seekingColumn < col && Character.isDigit(matrix[index_r][seekingColumn])) {
                                seekingChar = matrix[index_r][seekingColumn];
                                seekingColumn++;
                                numberString += seekingChar;
                            }
                            totalSum += Integer.parseInt(numberString);
                        }

                        // Find number on line below
                        for (int incrementColumnIndex = index_c - 1; incrementColumnIndex <= index_c + 1; incrementColumnIndex++) {
                            if (Character.isDigit(matrix[index_r + 1][incrementColumnIndex])) {

                                // Find the first number in the sequence
                                char seekingChar = matrix[index_r + 1][incrementColumnIndex];
                                int seekingColumn = incrementColumnIndex;
                                while (seekingColumn > 0 && Character.isDigit(matrix[index_r + 1][seekingColumn - 1])) {
                                    seekingChar = matrix[index_r + 1][seekingColumn - 1];
                                    seekingColumn--;
                                }
                                // Find the whole number
                                String numberString = "";
                                while (seekingColumn < col && Character.isDigit(matrix[index_r + 1][seekingColumn])) {
                                    seekingChar = matrix[index_r + 1][seekingColumn];
                                    seekingColumn++;
                                    numberString += seekingChar;
                                }
                                incrementColumnIndex = seekingColumn;
                                totalSum += Integer.parseInt(numberString);
                            }
                        }
                    }
                }
            }

            System.out.println("\nTotal Sum: " + totalSum);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}