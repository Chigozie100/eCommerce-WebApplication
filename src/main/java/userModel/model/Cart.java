package userModel.model;

public class Cart{
    private int proId;
    private int userId;
    private int quantity;

    public Cart(){
    }

    public Cart(int proId, int userId, int quantity) {
        this.proId = proId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public int getProInt() {
        return proId;
    }

    public void setProInt(int proId) {
        this.proId = proId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "proId=" + proId +
                ", userId=" + userId +
                ", quantity=" + quantity +
                '}';
    }
}
