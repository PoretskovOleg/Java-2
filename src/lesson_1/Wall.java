package lesson_1;

public class Wall implements Obstacle {

    private int height;

    Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }

    @Override
    public boolean isSuccessResult(Action object) {
        object.jump();
        return object.getMaxJump() >= this.height;
    }
}
