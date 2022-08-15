package apps.inheritance;

public class Cat extends Animal {
    private static int count;
    private String name;
    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MAX_SWIM_DISTANCE = 0;
    private static final String UNIT_OF_MEASUREMENT = "m";

    public Cat() {
        count++;
    }

    public Cat(String name) {
        this.name = validateName(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = validateName(name);
    }

    @Override
    public String run (int distance) {
        if (distance > 0 && distance <= MAX_RUN_DISTANCE) {
            return getName() + " ran " + distance + " "
                    + UNIT_OF_MEASUREMENT + ".";
        }

        if (distance > MAX_RUN_DISTANCE) {
            return getName() + " ran only " + MAX_RUN_DISTANCE + " "
                    + UNIT_OF_MEASUREMENT + " from " + distance + " and very tired.";
        }

        return "Sorry, maybe you input an invalid value...";
    }

    @Override
    public String swim (int distance) {
        if (distance >= MAX_SWIM_DISTANCE) {
            return "Oh no! But cats can't swim!";
        }

        return "Sorry, maybe you input an invalid value...";
    }
}