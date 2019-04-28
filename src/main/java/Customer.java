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
        throw new IllegalArgumentException();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Integer register(Rental rental) {
        list.add(rental);
        return list.size();
    }

    public void Info(VideoDao videoDao) {
        Integer totol = list.stream().mapToInt(Rental::getAmount).sum();
        System.out.println("비디오샾에서총대여가격: "+totol);
        Integer sum = 0;
        for (Rental rental: list) {
            sum += printRentalInfo(rental,videoDao);
        }
        System.out.println("총 대여 비디오수 : "+sum);
    }
    private Integer printRentalInfo(Rental rental, VideoDao videoDao) {
        Integer amount = rental.getAmount();
        System.out.println("대여가격 : "+amount);
        for(Order order :rental.getList()) {
            System.out.println("대여기간 : "+order.date());
            Video video = videoDao.get(order.title());
            video.info();
        }
        return (int)rental.getList().stream().count();
    }
}
