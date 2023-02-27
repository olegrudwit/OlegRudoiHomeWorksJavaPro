package apps.polymorphism.competition;

public class Wall extends Barrier {
    private double height;

    public Wall(String name, double height) {
        super.name = name;
        this.height = height;
    }

    @Override
    public boolean overcome(Competitor competitor) {
        return competitor.jump(height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wall wall = (Wall) o;

        if (Double.compare(wall.height, height) != 0) return false;
        return name.equals(wall.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}