package CaseStudy.models;

public class Customer extends  Person{
    private String tyle;

    public Customer() {
    }

    public Customer(String tyle) {
        this.tyle = tyle;
    }

    public Customer(String id, String name, int age, String address, int idCard, String email, String tyle) {
        super(id, name, age, address, idCard, email);
        this.tyle = tyle;
    }

    public String getTyle() {
        return tyle;
    }

    public void setTyle(String tyle) {
        this.tyle = tyle;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tyle='" + tyle + '\'' +
                '}';
    }
}
