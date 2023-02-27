package apps.polymorphism.competition;

public class Robot extends Competitor {
    private double maxRunDistance;
    private double maxJumpHeight;
    private boolean isReady = true;

    public Robot(String name, double maxRunDistance, double maxJumpHeight) {
        super.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    boolean isReadyToNext() {
        return isReady;
    }

    @Override
    public boolean run(double distance) {
        if (distance < 0) {
            System.out.println(distance + " - it's not a real distance. Please check");
        } else if (distance > maxRunDistance) {
            System.out.println(name + " is to tired with best result "
                    + this.maxRunDistance + " and failed the competition");
        } else {
            System.out.println(name + " ran the distance " + distance);
            return true;
        }
        isReady = false;
        return false;
    }

    @Override
    public boolean jump(double height) {
        if (height < 0) {
            System.out.println(height + " - it's not a real height. Please check");
        } else if (height > maxJumpHeight) {
            System.out.println(name + " crashed with best result "
                    + this.maxJumpHeight + " and failed the competition");
        } else {
            System.out.println(name + " jumped to a height " + height);
            return true;
        }
        isReady = false;
        return false;
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

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (Double.compare(robot.maxRunDistance, maxRunDistance) != 0) return false;
        if (Double.compare(robot.maxJumpHeight, maxJumpHeight) != 0) return false;
        if (isReady != robot.isReady) return false;
        return name.equals(robot.name);
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
        result = 31 * result + (isReady ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", maxRunDistance=" + maxRunDistance +
                ", maxJumpHeight=" + maxJumpHeight +
                ", isReady=" + isReady +
                '}';
    }
}