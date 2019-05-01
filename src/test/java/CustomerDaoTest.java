import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerDaoTest {
    CustomerDao customerDao;
    Customer eunnam;
    Customer other;

    @Before
    public void 초기화() {
        customerDao = new CustomerDao();
        eunnam = new Customer("eunnam");
        customerDao.add("eunnam", eunnam);
        other = new Customer("other");
        customerDao.add("other", other);
    }

    @Test
    public void 이름을가지고가입할수있다() {
        Customer customer = customerDao.add("eunnam", new Customer("eunnam"));
        assertThat(customer,is(eunnam));
    }
    @Test
    public void 이름을가지고손님정보를가져올수있다() {
        assertThat(customerDao.get("eunnam"), is(eunnam));
        assertThat(customerDao.get("other"),is(other));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 등록되지않은고객을조회한다() {
        customerDao.get("bad");
    }
}
