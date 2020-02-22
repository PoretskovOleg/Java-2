package lesson_1;

public class Person implements Action {

    private int maxRun;
    private int maxJump;

    Person(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public void run() {
        System.out.println("Человек бежит");
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгает");
    }

    @Override
    public String toString() {
        return "Person{" +
                "maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                '}';
    }
}
