package lesson_2;

import java.util.Arrays;

public class MyArrayDataException extends NumberFormatException {

    private String index;

    public MyArrayDataException(int... index) {
        this.index = Arrays.toString(index);
    }

    public void getMessageException() {
        System.out.printf("Ошибка в элементе массива с индексом %s", this.index);
    }

}
