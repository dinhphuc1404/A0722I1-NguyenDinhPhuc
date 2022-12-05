package ss17_IOFileBnary.BaiTap;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID=1L;
    private int codeId;
    private String name;
    private String manufacturer;
    private double price;
    private String description;

    public Product() {
    }

    public Product(int codeId, String name, String manufacturer, double price, String description) {
        this.codeId = codeId;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "CodeID=" + codeId +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
