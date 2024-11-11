import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class code {
    public static void main(String[] args) {
        String fileName = "/home/emil/AdventofCode/2023/day3/star2/data.txt";
        // String fileName = "/home/emil/AdventofCode/2023/day3/star2/test.txt";
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
            for (int index_r = 0; index_r < row; index_r++) {
                for (int index_c = 0; index_c < col; index_c++) {
                    if (matrix[index_r][index_c] == '*') {
                        ArrayList<Integer> numbers = new ArrayList<>();

                        // Check row over
                        if (index_r > 0) {
                            for (int dc = -1; dc <= 1; dc++) {
                                if (index_c + dc >= 0 && index_c + dc < col && Character.isDigit(matrix[index_r - 1][index_c + dc])) {

                                    // Find the first number in the sequence
                                    int start = index_c + dc;
                                    while (start > 0 && Character.isDigit(matrix[index_r - 1][start - 1])) {
                                        start--;
                                    }
                                    // Find the whole number
                                    StringBuilder numberString = new StringBuilder();
                                    while (start < col && Character.isDigit(matrix[index_r - 1][start])) {
                                        numberString.append(matrix[index_r - 1][start]);
                                        start++;
                                    }
                                    numbers.add(Integer.parseInt(numberString.toString()));
                                    // Skip the rest of the found number
                                    dc = start - index_c - 1;
                                }
                            }
                        }

                        // Check same row
                        for (int dc : new int[] { -1, 1 }) {
                            if (index_c + dc >= 0 && index_c + dc < col && Character.isDigit(matrix[index_r][index_c + dc])) {
                                // Find start of number
                                int start = index_c + dc;
                                while (start > 0 && Character.isDigit(matrix[index_r][start - 1])) {
                                    start--;
                                }
                                // Extract full number
                                StringBuilder num = new StringBuilder();
                                while (start < col && Character.isDigit(matrix[index_r][start])) {
                                    num.append(matrix[index_r][start]);
                                    start++;
                                }
                                numbers.add(Integer.parseInt(num.toString()));
                            }
                        }

                        // Check row below
                        if (index_r < row - 1) {
                            for (int dc = -1; dc <= 1; dc++) {
                                if (index_c + dc >= 0 && index_c + dc < col && Character.isDigit(matrix[index_r + 1][index_c + dc])) {
                                    // Find start of number
                                    int start = index_c + dc;
                                    while (start > 0 && Character.isDigit(matrix[index_r + 1][start - 1])) {
                                        start--;
                                    }
                                    // Extract full number
                                    StringBuilder num = new StringBuilder();
                                    while (start < col && Character.isDigit(matrix[index_r + 1][start])) {
                                        num.append(matrix[index_r + 1][start]);
                                        start++;
                                    }
                                    numbers.add(Integer.parseInt(num.toString()));
                                    // Skip the rest of this number
                                    dc = start - index_c - 1;
                                }
                            }
                        }

                        // If exactly two numbers were found, multiply them
                        if (numbers.size() == 2) {
                            totalSum += numbers.get(0) * numbers.get(1);
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