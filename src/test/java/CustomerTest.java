import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    Customer customer;

    @Before
    public void init() {
        customer = new Customer("eunnam");
    }

    @Test
    public void 고객은이름을가지고있다() {
        customer = new Customer("eunnam");
//        assertThat(customer.name,is(new Customer("eunnam").name));
//        assertThat(customer.name,is(not(new Customer("different").name)));
        assertThat(customer, is(new Customer("eunnam")));
        assertThat(customer, is(not(new Customer("different"))));
    }

    @Test
    public void 고객의이름은대소문자를구별하지않는다() {
        customer = new Customer("eunnam");
        assertThat(customer, is(new Customer("EUNNAM")));
    }

    @Test
    public void 고객은여러개의비디오를대여할수있다() {
        customer = new Customer("eunnam");
        assertThat(customer.getRentalCount(),is(3));
        assertThat(customer.getRentalPrice(),is(2000));
    }
}
