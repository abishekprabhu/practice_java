public class Widgets {
    private String color;
    private Integer weight;

    public Widgets(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Widgets{" +
                "color='" + color + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
