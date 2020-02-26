package lesson_2;

import java.util.Arrays;
import java.util.Random;

public class Task {

    private static final int SIZE_1 = 4;
    private static final int SIZE_2 = 4;

    private static Random random = new Random();

    public static void main(String[] args) {
        String[][] myArray = initArray();
        printSumArray(myArray);
    }

    private static void printSumArray(String[][] myArray) {
        try {
            int sumArray = getSumArrayElements(myArray);
            System.out.printf("Сумма элементов массива - %d", sumArray);
        } catch (MyArraySizeException e) {
            e.getMessageException();
        } catch (MyArrayDataException e) {
            e.getMessageException();
        }
    }

    private static String[][] initArray() {
        int size1 = random.nextInt(SIZE_1) + 1;
        int size2 = random.nextInt(SIZE_2) + 1;
        System.out.printf("Размер массива %d на %d%n", size1, size2);
        System.out.println("==========================");
        String[][] arrStrings = new String[size1][size2];

        int randomIndex = random.nextInt(SIZE_1 * SIZE_2);

        for (int i = 0; i < size1; i++) {

            for (int j = 0; j < size2; j++) {
                arrStrings[i][j] = (randomIndex == i || randomIndex == j ? "str" : "") + random.nextInt(SIZE_1 * SIZE_2);
            }

            System.out.println(Arrays.toString(arrStrings[i]));
        }

        System.out.println("==========================");

        return arrStrings;
    }

    private static void checkSizeArray(String[][] array) {

        boolean isCorrectSize1 = array.length == SIZE_1;
        boolean isCorrectSize2 = array[0].length == SIZE_2;

        if (!isCorrectSize1 || !isCorrectSize2) {
            throw new MyArraySizeException(SIZE_1, SIZE_2);
        }
    }

    public static int getSumArrayElements( String[][] array) {

        checkSizeArray(array);

        int sum = 0;
        int i, j;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
