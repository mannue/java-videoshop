import java.util.Arrays;

public class VideoShop {
    private CustomerManager customerManager;
    private VideoManager videoManager;

    public VideoShop(CustomerManager customerManager, VideoManager videoManager) {
        this.customerManager = customerManager;
        this.videoManager = videoManager;
    }

    public Integer expectedAmount(Order... orders) {
        Integer sum = 0;
        for (Order order : orders) {
            Video video = order.video();
            sum += video.calculateAmount(order.date());
        }
        return sum;
    }

    public Customer rent(String name, Order... orders) {
        Customer customer = customerManager.get(name);
        validationOrders(orders);
        customer.register(orders);
        return customer;
    }

    private void validationOrders(Order ... orders) {
        try{
            Arrays.stream(orders).map(Order::video).map(Video::getTitle).forEach(this::findVideo);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    public Video findVideo(String title) {
        return videoManager.get(title);
    }
}
