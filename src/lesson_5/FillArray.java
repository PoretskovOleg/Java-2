package lesson_5;

public class FillArray {

    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private float[] arr = new float[SIZE];

    public void method1() {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long time1 = System.currentTimeMillis();

        reCalcArray(arr, 0, SIZE);

        long time2 = System.currentTimeMillis();

        System.out.println("Время работы метода method1 - " + (time2 - time1));
        System.out.println(arr[SIZE - 1]);
    }

    public void method2() {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long time1 = System.currentTimeMillis();

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread thread1 = new Thread(() -> reCalcArray(arr1, 0, HALF));
        Thread thread2 = new Thread(() -> reCalcArray(arr2, HALF, HALF));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        long time2 = System.currentTimeMillis();

        System.out.println("Время работы метода method2 - " + (time2 - time1));
        System.out.println(arr[SIZE - 1]);
    }

    private void reCalcArray(float[] array, int offset, int size) {
        for (int i = 0; i < size; i++) {
            int k = i + offset;
            array[i] = (float)(array[i] * Math.sin(0.2f + (float)(k / 5)) * Math.cos(0.2f + (float)(k / 5)) * Math.cos(0.4f + (float) (k / 2)));
        }
    }
}
