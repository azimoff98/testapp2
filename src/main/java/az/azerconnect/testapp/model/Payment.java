package az.azerconnect.testapp.model;

public class Payment {




    private Integer amount;
    private String type;

    public Payment(Integer amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
