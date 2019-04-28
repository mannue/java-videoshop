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
    public void 고객은이름을가지고있다() {
//        assertThat(customer.name,is(new Customer("eunnam").name));
//        assertThat(customer.name,is(not(new Customer("different").name)));
        assertThat(validCustomer, is(new Customer("eunnam")));
        assertThat(validCustomer, is(not(new Customer("different"))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 고객을잘못된대상과비교한다() {
        validCustomer.equals(null);
    }

    @Test
    public void 고객은빌린비디오와총금액을가지고있다() {
        Customer customer = new Customer("eunnam");
        Integer size = customer.register(new Rental(10000,new Order("fifa",10)));
        assertThat(size, is(1));
    }
    @Test
    public void 고객은여러개빌린비디오와총금액을가지고있다() {
        Customer customer = new Customer("eunnam");
        Rental rental = new Rental(20000);
        rental.add(new Order("fifa", 10), new Order("ring", 5));
        Integer size = customer.register(rental);
        assertThat(size, is(1));
    }
}