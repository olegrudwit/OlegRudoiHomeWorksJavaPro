package apps.polymorphism.competition;

public class Main {
    public static void main(String[] args) {
        Barrier[] barriers = initBarriers();
        Participant[] participants = initParticipants();
    }

    private static Participant[] initParticipants() {
        return new Participant[0];
    }

    private static Barrier[] initBarriers() {
        Racetrack racetrack1 = new Racetrack(200);
        Wall wall1 = new Wall(0.4);
        Wall wall2 = new Wall(1.0);
        Racetrack racetrack2 = new Racetrack(800);;
        return new Barrier[]{racetrack1, wall1, wall2, racetrack2};
    }
}
