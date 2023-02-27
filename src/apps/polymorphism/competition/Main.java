package apps.polymorphism.competition;

public class Main {
    public static void main(String[] args) {
        Barrier[] barriers = initBarriers();
        Competitor[] competitors = initParticipants();

        startGames(barriers, competitors);
    }

    private static void startGames(Barrier[] barriers, Competitor[] competitors) {
        for (Barrier barrier : barriers) {
            System.out.println(barrier);
            for (Competitor competitor : competitors) {
                if (!competitor.isReadyToNext()) {
                    continue;
                }
                barrier.overcome(competitor);
            }
            System.out.println();
        }

        System.out.println("They are completed the competition:");
        for (Competitor c : competitors) {
            if (!c.isReadyToNext()) {
                continue;
            }
            System.out.println(c);
        }
    }

    private static Competitor[] initParticipants() {
        Human human1 = new Human("Benicio", 4000, 1.0);
        Human human2 = new Human("Consuelo", 4000, 1.1);
        Cat cat1 = new Cat("Tom", 800, 1.50);
        Cat cat2 = new Cat("Jerry", 700, 1.60);
        Robot robot1 = new Robot("C3P", 10000, 1.0);
        Robot robot2 = new Robot("R2D", 1000, 0.2);

        return new Competitor[]{human1, human2, cat1, cat2, robot1, robot2};
    }

    private static Barrier[] initBarriers() {
        Racetrack racetrack1 = new Racetrack("racetrack1", 200);
        Wall wall1 = new Wall("wall1",0.4);
        Wall wall2 = new Wall("wall2",1.0);
        Racetrack racetrack2 = new Racetrack("racetrack2",800);

        return new Barrier[]{racetrack1, wall1, wall2, racetrack2};
    }
}
