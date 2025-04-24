package frozen.ingredient.checkIngredient;

public class Ingredient {
    private String ingredientName;
    private int amount;
    private String deadLine;
    private String location;

    public Ingredient(String ingredientName, int amount, String deadLine,String location) {
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.deadLine = deadLine;
        this.location = location;
    }

    public Ingredient() {

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

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
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
