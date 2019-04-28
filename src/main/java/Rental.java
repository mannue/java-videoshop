import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Rental {
    private Integer amount;
    private List<Order> list = new ArrayList<>();

    public Rental(Integer amount, Order order) {
        this(amount);
        list.add(order);
    }

    public Rental(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        Rental rental = (Rental) obj;
        return Objects.equals(amount, rental.amount) &&
                Objects.equals(list.size(), rental.list.size());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, list);
    }

    public Integer add(Order... orders) {
        list.addAll(Arrays.asList(orders));
        return list.size();
    }
}

