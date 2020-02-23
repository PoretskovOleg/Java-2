package lesson_1;

public class RunningTrack implements Obstacle {

    private int length;

    RunningTrack(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "RunningTrack{" +
                "length=" + length +
                '}';
    }

    @Override
    public boolean isSuccessResult(Action object) {
        object.run();
        return object.getMaxRun() >= this.length;
    }
}
