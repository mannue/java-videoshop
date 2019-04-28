import java.util.List;

public class VideoShop {
    public UserDao userDao;
    public VideoDao videoDao;

    public VideoShop(UserDao userDao, VideoDao videoDao) {
        this.userDao = userDao;
        this.videoDao = videoDao;
    }

    public Integer expectedAmount(Order ... orders) {
        Integer sum = 0;
        for (Order order : orders) {
            Video video = videoDao.get(order.title());
            sum += video.getAmount(order.date());
        }
        return sum;
    }

    public Customer rent(String name, Order ... ordes) {
        Customer customer = userDao.get(name);
        Rental rental = new Rental(expectedAmount(ordes));
        for (Order order : ordes) {
            rental.add(order);
        }
        customer.register(rental);
        return customer;
    }


    public void info(String name) {
        Customer customer = userDao.get(name);
        customer.Info(videoDao);
    }
}
