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

    public Customer rent(String name, Order... ordes) {
        Customer customer = customerManager.get(name);
        customer.register(ordes);
        return customer;
    }

    public Video getVideo(String title) {
        return videoManager.get(title);
    }

    public void printCustomerInfo(String name) {
        Customer customer = customerManager.get(name);
        System.out.println(customer);
    }
}
