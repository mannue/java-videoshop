import java.util.Objects;

public class Order {
    private Video video;
    private Integer date;

    public Order(Video video, Integer date) {
        this.video = video;
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != getClass()) return false;
        if(obj == this) return true;
        Order order = (Order) obj;
        return Objects.equals(order.video(),video) && Objects.equals(order.date(),date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(video, date);
    }

    public Video video() {
        return video;
    }

    public Integer date() {
        return date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "video=" + video +
                ", date=" + date +
                '}';
    }
}
