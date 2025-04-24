package frozen.ingredient.deleteIngredient;


import java.time.LocalDate;

public class Ingredient {
    private String ingredientName;
    private int amount;
    private LocalDate deadLine;
    private String location;

    public Ingredient(String ingredientName, int amount, LocalDate deadLine, String location) {
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.deadLine = deadLine;
        this.location = location;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientName='" + ingredientName + '\'' +
                ", amount=" + amount +
                ", deadLine=" + deadLine +
                ", location='" + location + '\'' +
                '}';
    }
}
