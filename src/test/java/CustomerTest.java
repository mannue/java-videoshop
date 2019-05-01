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
    public void 고객은이름이같으면같은객체이고이름이다르면다른객체이다() {
        assertThat(validCustomer, is(new Customer("eunnam")));
        assertThat(validCustomer, is(not(new Customer("different"))));
    }

    public void 고객을잘못된대상과비교한다() {
        assertThat(validCustomer.equals(null),is(false));
    }

    @Test
    public void 고객은_빌린비디오_총금액_을가지고있다() {
        Customer customer = new Customer("eunnam");
        Integer size = customer.register(new Rental(10000,new Order("fifa",10)));
        assertThat(size, is(1));
    }
    @Test
    public void 고객은_렌탈정보를_등록하면지금까지_등록된렌탈갯수_를알수있다() {
        Customer customer = new Customer("eunnam");
        Rental rental = new Rental(20000,new Order("fifa", 10), new Order("ring", 5));
        Integer rentalSum = customer.register(rental);
        assertThat(rentalSum, is(1));
    }
}