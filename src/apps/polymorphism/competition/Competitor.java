package apps.polymorphism.competition;

public abstract class Competitor {
    protected String name;
    abstract boolean isReadyToNext();
    abstract boolean run(double distance);
    abstract boolean jump(double height);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
