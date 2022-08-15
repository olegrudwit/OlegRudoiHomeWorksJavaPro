package apps.inheritance;

public class Animal {
    private static int count;
    protected String name;
    private static final String UNIT_OF_MEASUREMENT = "m";

    public Animal() {
        count++;
    }

    public Animal(String name) {
        this.name = validateName(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateName(name);
    }

    public String run(int distance) {
        if (distance > 0) {
            return getName() + " ran " + distance + " "
                    + UNIT_OF_MEASUREMENT + ".";
        }

        return "Sorry, maybe you input an invalid value...";
    }

    public String swim(int distance) {
        if (distance > 0) {
            return getName() + " swam " + distance + " "
                    + UNIT_OF_MEASUREMENT + ".";
        }

        return "Sorry, maybe you input an invalid value...";
    }

    protected String validateName(String name) {
        String string = name.trim().replaceAll("\\W", "");
        if (string.isEmpty()) {
            System.out.println("Incorrect name! Please try again");
        }
        return string;
    }
}