import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    Customer validCustomer;

    @Before
    public void init() {
        validCustomer = new Customer("eunnam");
    }

    @Test
    public void 고객은_이름이_같으면_같은객체이고_이름이_다르면_다른객체이다() {
        assertThat(validCustomer, is(new Customer("eunnam")));
        assertThat(validCustomer, is(not(new Customer("different"))));
    }

    @Test
    public void 고객을_잘못된대상과_비교한다() {
        assertThat(validCustomer.equals(null),is(false));
    }

    @Test
    public void 고객은_빌린비디오_총금액을_가지고있다() {
        Customer customer = new Customer("eunnam");
        Video video = new Video(VideoType.SPORT,"월드컵",1000,10);
        Integer size = customer.register(new Order(video,10));
        assertThat(size, is(1));
    }
    @Test
    public void 고객은_빌린정보를_가지고있다() {
        Customer customer = new Customer("eunnam");
        Video video = new Video(VideoType.SPORT,"월드컵",1000,10);
        Integer rentalSum = customer.register(new Order(video,5));
        assertThat(rentalSum, is(1));
    }
}