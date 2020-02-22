package lesson_1;

public class Cat implements Action {

    private int maxRun;
    private int maxJump;

    Cat(int maxRun, int maxJump) {
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
        System.out.println("Кот бежит.");
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгает.");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                '}';
    }
}
