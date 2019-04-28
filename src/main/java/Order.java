import java.util.Objects;

public class Order {
    private String title;
    private Integer date;

    public Order(String title, Integer date) {
        this.title = title;
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            return Objects.equals(title, order.title) &&
                    Objects.equals(date, order.date);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date);
    }

    public String title() {
        return this.title;
    }

    public Integer date() {
        return date;
    }
}
