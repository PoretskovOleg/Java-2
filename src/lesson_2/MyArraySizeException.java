package lesson_2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{

    private int[] sizes;

    public MyArraySizeException(int... size) {
        this.sizes = size;
    }

    public void getMessageException() {

        StringBuilder sizeArray = new StringBuilder();
        sizeArray.append(this.sizes[0]);
        if (this.sizes.length > 1) {
            for (int i = 1; i < this.sizes.length; i++) {
                sizeArray.append(" на ").append(this.sizes[i]);
            }
        }

        System.out.printf("Неверный размер массива. Размер массива должен быть %s", sizeArray);
    }

}
