package apps.inheritance;

public class Dog extends Animal {
    private static int count;
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    private static final String UNIT_OF_MEASUREMENT = "m";

    public Dog() {
        count++;
    }

    public Dog(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String run(int distance) {
        if (distance > 0 && distance <= MAX_RUN_DISTANCE) {
            return getName() + " ran " + distance + " " + UNIT_OF_MEASUREMENT + ".";
        }

        if (distance > MAX_RUN_DISTANCE) {
            return getName() + " ran only " + MAX_RUN_DISTANCE + " "
                    + UNIT_OF_MEASUREMENT + " from " + distance + " and very tired.";
        }

        return "Sorry, maybe you input an invalid value...";
    }

    @Override
    public String swim(int distance) {
        if (distance > 0 && distance <= MAX_SWIM_DISTANCE) {
            return getName() + " swam " + distance + " " + UNIT_OF_MEASUREMENT + ".";
        }

        if (distance > MAX_SWIM_DISTANCE) {
            return getName() + " swam only " + MAX_SWIM_DISTANCE + " "
                    + UNIT_OF_MEASUREMENT + " from " + distance + " and very tired.";
        }

        return "Sorry, maybe you input an invalid value...";
    }
}