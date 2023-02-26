package apps.polymorphism.competition;

public class Cat implements Participant {
    private String name;
    private double maxRunDistance;
    private double maxJumpHeight;
    private boolean isCompetitor = true;

    public Cat(String name, double maxRunDistance, double maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(double distance) {
        if (distance < 0) {
            System.out.println(distance + " - it's not a real distance. Please check");
            return false;
        } else if (distance > maxRunDistance) {
            System.out.println("Cat is to tired and failed the competition");
            return false;
        } else {
            System.out.println("Cat ran the distance " + distance);
            return true;
        }
    }

    @Override
    public boolean jump(double height) {
        if (height < 0) {
            System.out.println(height + " - it's not a real height. Please check");
            return false;
        } else if (height > maxJumpHeight) {
            System.out.println("Cat crashed and failed the competition");
            return false;
        } else {
            System.out.println("Cat jumped to a height " + height);
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxRunDistance() {
        return maxRunDistance;
    }

    public void setMaxRunDistance(double maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public double getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public void setMaxJumpHeight(double maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    public boolean isCompetitor() {
        return isCompetitor;
    }

    public void setCompetitor(boolean competitor) {
        isCompetitor = competitor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (Double.compare(cat.maxRunDistance, maxRunDistance) != 0) return false;
        if (Double.compare(cat.maxJumpHeight, maxJumpHeight) != 0) return false;
        if (isCompetitor != cat.isCompetitor) return false;
        return name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(maxRunDistance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxJumpHeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isCompetitor ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", maxRunDistance=" + maxRunDistance +
                ", maxJumpHeight=" + maxJumpHeight +
                ", isCompetitor=" + isCompetitor +
                '}';
    }
}