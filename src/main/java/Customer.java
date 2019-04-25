import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;
    private List<Rental> infos = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer customer = (Customer) obj;
            return Objects.equals(name.toLowerCase(), customer.name.toLowerCase());
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Integer getRentalCount() {
        return infos.size();
    }

    public Integer getRentalPrice() {
        return infos.stream().mapToInt(Rental::fee).sum();
    }

    public String getName() {
        return name;
    }

    public void register(Rental rental) {
        if (rental == null) throw new IllegalArgumentException();
        infos.add(rental);
    }
}
