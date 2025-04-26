package frozen.ingredient;

import java.time.LocalDate;

public class Ingredient {
    private String ingredientName;
    private int amount;
    private LocalDate deadLine;
    private String location;
    private int memNo;


    public Ingredient() {

    }

    public Ingredient(String ingredientName,int amount) {
        this.ingredientName = ingredientName;
        this.amount = amount;
    }

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

    public int getMemNo() {return memNo;}

    public void setMemNo(int memNo) {this.memNo = memNo;}


    @Override
    public String toString() {
        return "["+" 재료명 :" + ingredientName + " 재료 수량 : " + amount +  " 유통 기한 " + deadLine + " 보관 위치 " + location+ " "+memNo+ "]";
    }
}
