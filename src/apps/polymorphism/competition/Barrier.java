package apps.polymorphism.competition;

public abstract class Barrier {
    protected String name;
    abstract boolean overcome(Competitor competitor);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
