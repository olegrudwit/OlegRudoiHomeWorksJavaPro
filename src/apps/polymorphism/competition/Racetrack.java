package apps.polymorphism.competition;

public class Racetrack implements Barrier {
    private double distance;

    public Racetrack(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.run(distance);
    }
}
