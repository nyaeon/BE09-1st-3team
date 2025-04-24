package frozen.ingredientManagement;

import java.time.LocalDate;

public class Menagement {
    private LocalDate date;
    private int reason;
    private int amount;
    private String name;

    public Menagement(LocalDate date, int reason, int amount, String name) {
        this.date = date;
        this.reason = reason;
        this.amount = amount;
        this.name = name;
    }

    public Menagement() {

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Management{" +
                "date=" + date +
                ", reason=" + reason +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}
