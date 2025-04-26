package frozen.ingredientManagement;

import java.time.LocalDate;

public class Management {
    private LocalDate date;
    private int reason;
    private int amount;
    private String name;
    private int memNo;

    public Management(LocalDate date, int reason, int amount, String name, int memNo) {
        this.date = date;
        this.reason = reason;
        this.amount = amount;
        this.name = name;
        this.memNo = memNo;
    }

    public Management() {

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

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    @Override
    public String toString() {
        return "["  + name + " " + reason + " 폐기량 :  " + amount + " 폐기일 : " + date +  ']';
    }
}
