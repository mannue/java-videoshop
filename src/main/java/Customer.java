import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;
    private List<Rental> list = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer customer = (Customer) obj;
            return Objects.equals(name, customer.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Integer register(Rental rental) {
        list.add(rental);
        return list.size();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    public List<Rental> getRentalList() {
        return list;
    }
}
