package userModel.model;

public class Product {
    private int pro_id;
    private String pro_name;
    private String pro_price;
    private int pro_qty;
    private String pro_category;
    private String image;

    public Product(){

    }

    public Product(int pro_id, String pro_name, String pro_price, int pro_qty, String pro_category, String image) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.pro_qty = pro_qty;
        this.pro_category = pro_category;
        this.image = image;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_price() {
        return pro_price;
    }

    public void setPro_price(String pro_price) {
        this.pro_price = pro_price;
    }

    public int getPro_qty() {
        return pro_qty;
    }

    public void setPro_qty(int pro_qty) {
        this.pro_qty = pro_qty;
    }

    public String getPro_category() {
        return pro_category;
    }

    public void setPro_category(String pro_category) {
        this.pro_category = pro_category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                ", pro_price='" + pro_price + '\'' +
                ", pro_qty=" + pro_qty +
                ", pro_category='" + pro_category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
