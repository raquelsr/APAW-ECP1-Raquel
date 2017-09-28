package es.upm.miw.apaw.ecp1.entities;

import java.math.BigDecimal;
import java.util.Calendar;

public class Order {

    private int id;

    private Calendar date;

    private BigDecimal amount;

    public Order(int id, Calendar date, BigDecimal amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", date=" + date + ", amount=" + amount + "]";
    }

}
