package lesson_1;

public class Robot implements Action {

    private int maxRun;
    private int maxJump;

    Robot(int maxRun, int maxJump) {
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
        System.out.println("Робот бежит.");
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгает.");
    }

    @Override
    public String toString() {
        return "Robot{" +
                "maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                '}';
    }
}
