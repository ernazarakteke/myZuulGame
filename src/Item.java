public class Item {
    private String name;
    private String description;
    private double weight;

    private int score;
    private boolean moveable = true;

    public Item(String name, String description, double weight, int score) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.score = score;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public void setMoveable(boolean moveable) {
        this.moveable = moveable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getItemDescription() {
        return name + " (" + description + ") with weight of " + weight + "kg (+"+ score+")points" ;
    }
}
