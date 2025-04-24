package frozen.common.domain;

import java.time.LocalDate;

public class Ingredients {

    private String name;
    private int amount;
    private LocalDate expDate;
    private String location;

    public Ingredients() {
    }

    public Ingredients(String name) {
        this.name = name;
    }

    public Ingredients(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Expiration{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", expDate=" + expDate +
                ", location='" + location + '\'' +
                '}';
    }
}
