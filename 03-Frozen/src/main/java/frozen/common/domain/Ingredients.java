package frozen.common.domain;

import java.time.LocalDate;

public class Ingredients {

    private String name;
    private int amount;
    private LocalDate expDate;
    private String location;
    private int memNo;

    public Ingredients() {
    }

    public Ingredients(String name, int amount, LocalDate expDate, String location) {
        this.name = name;
        this.amount = amount;
        this.expDate = expDate;
        this.location = location;
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

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    @Override
    public String toString() {
        return String.format("재료명: %-8s\t 수량: %-3d\t 보관 위치: %-2s\t 유통 기한: %s", name, amount, location, expDate);
    }
}
