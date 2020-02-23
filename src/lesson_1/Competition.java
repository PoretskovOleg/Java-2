package lesson_1;

import java.util.Random;

public class Competition {

    public static final int COUNT_RUNNING_TRACKS = 2;
    public static final int COUNT_WALLS = 2;
    public static final int MAX_RUNNING_LENGTH = 10;
    public static final int MAX_WALL_HEIGHT = 10;

    public static final int MAX_LENGTH_RUN = 20;
    public static final int MAX_HEIGHT_JUMP = 20;
    public static final int COUNT_COMPETITORS = 5;

    public static Random random = new Random();

    public static void main(String[] args) {

        Obstacle[] obstacles = initObstacles();

        Action[] competitors = initCompetitors();

        competitions(obstacles, competitors);
    }

    /**
     * Все участники проходят препятствия
     * @param obstacles - массив препятствий
     * @param competitors - массив участников соревнований
     */
    private static void competitions(Obstacle[] obstacles, Action[] competitors) {
        boolean isSuccess;
        for (Action competitor : competitors) {
            System.out.println(competitor);
            isSuccess = true;
            for (Obstacle obstacle : obstacles) {
                System.out.println("---------------------");
                System.out.println(obstacle);
                if (!obstacle.isSuccessResult(competitor)) {
                    System.out.println("Препятствие не пройдено.");
                    isSuccess = false;
                    break;
                }
                System.out.println("Препятствие пройдено!");
            }

            if(isSuccess) {
                System.out.println("Все препятствия пройдены!");
            }

            System.out.println("================================");
        }
    }

    /**
     * Формируем участиков соревнований
     * @return - массив участников
     */
    private static Action[] initCompetitors() {

        Action[] competitors = new Action[COUNT_COMPETITORS];

        int maxRun, maxJump;

        for (int i = 0; i < COUNT_COMPETITORS; i += 3) {
            maxRun = random.nextInt(MAX_LENGTH_RUN);
            maxJump = random.nextInt(MAX_HEIGHT_JUMP);
            competitors[i] = new Person(maxRun, maxJump);

            if (i + 1 < COUNT_COMPETITORS) {
                maxRun = random.nextInt(MAX_LENGTH_RUN);
                maxJump = random.nextInt(MAX_HEIGHT_JUMP);
                competitors[i + 1] = new Cat(maxRun, maxJump);
            }

            if (i + 2 < COUNT_COMPETITORS) {
                maxRun = random.nextInt(MAX_LENGTH_RUN);
                maxJump = random.nextInt(MAX_HEIGHT_JUMP);
                competitors[i + 2] = new Robot(maxRun, maxJump);
            }
        }

        return (Action[]) shuffleObjects(competitors);
    }

    /**
     * Формируем препятствия
     * @return массив препятствий
     */
    private static Obstacle[] initObstacles() {

        Object[] obstacles = new Obstacle[COUNT_RUNNING_TRACKS + COUNT_WALLS];
        int length, height, i;
        for (i = 0; i < COUNT_RUNNING_TRACKS + COUNT_WALLS; i += 2) {
            length = random.nextInt(MAX_RUNNING_LENGTH) + 1;
            obstacles[i] = new RunningTrack(length);

            height = random.nextInt(MAX_WALL_HEIGHT) + 1;
            obstacles[i+1] = new Wall(height);
        }

        return (Obstacle[]) shuffleObjects(obstacles);
    }

    /**
     * Перемешиваем массив объектов
     * @param objects - массив объектов
     * @return - перемешанный массив объектов
     */
    private static Object[] shuffleObjects(Object[] objects) {

        for (int i = objects.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Object object = objects[index];
            objects[index] = objects[i];
            objects[i] = object;
        }

        return objects;
    }
}
