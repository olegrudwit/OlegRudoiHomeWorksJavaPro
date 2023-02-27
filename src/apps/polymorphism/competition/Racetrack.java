package apps.polymorphism.competition;

public class Racetrack extends Barrier {
    private double distance;

    public Racetrack(String name, double distance) {
        super.name = name;
        this.distance = distance;
    }

    @Override
    public boolean overcome(Competitor competitor) {
        return competitor.run(distance);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Racetrack racetrack = (Racetrack) o;

        if (Double.compare(racetrack.distance, distance) != 0) return false;
        return name.equals(racetrack.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(distance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Racetrack{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}