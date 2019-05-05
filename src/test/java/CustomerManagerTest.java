import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerManagerTest {
    CustomerManager customerDao;
    Customer eunnam;
    Customer other;

    @Before
    public void 초기화() {
        customerDao = new CustomerManager();
        eunnam = new Customer("eunnam");
        customerDao.add(eunnam);
        other = new Customer("other");
        customerDao.add(other);
    }

    @Test
    public void 고객은_이름을_가지고_가입할수있다() {
        Customer customer = customerDao.add(new Customer("eunnam"));
        assertThat(customer,is(eunnam));
    }
    @Test
    public void 고객이름을_가지고_손님정보를_가져올수있다() {
        assertThat(customerDao.get("eunnam"), is(eunnam));
        assertThat(customerDao.get("other"),is(other));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 등록되지않은고객을조회한다() {
        customerDao.get("bad");
    }
}
