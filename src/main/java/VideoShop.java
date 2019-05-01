import java.util.List;
import java.util.stream.Collectors;

public class VideoShop {
    private CustomerDao customerDao;
    private VideoDao videoDao;

    public VideoShop(CustomerDao customerDao, VideoDao videoDao) {
        this.customerDao = customerDao;
        this.videoDao = videoDao;
    }

    public Integer expectedAmount(Order... orders) {
        Integer sum = 0;
        for (Order order : orders) {
            Video video = videoDao.get(order.title());
            sum += video.calculateAmount(order.date());
        }
        return sum;
    }

    public Customer rent(String name, Order... ordes) {
        Customer customer = customerDao.get(name);
        Rental rental = new Rental(expectedAmount(ordes), ordes);
        customer.register(rental);
        return customer;
    }

    public void info(String name) {
        Customer customer = customerDao.get(name);
        System.out.println(customer);
        List<String> collect = customer.getRentalList().stream().map(Rental::getOrderList).flatMap(x -> x.stream().map(Order::title)).collect(Collectors.toList());
        for (String title : collect) {
            System.out.println(videoDao.get(title));
        }
    }

    public Customer registerCustomer(String name) {
        return customerDao.add(name, new Customer(name));
    }

    public void registerVideo(String title, Video video) {
        videoDao.add(title, video);
    }
}
