import java.util.Objects;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Customer customer = (Customer) obj;
        return name.toLowerCase().equals(customer.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Integer getRentalCount() {
        return 3;
    }

    public Object getRentalPrice() {
        return 2000;
    }
}
