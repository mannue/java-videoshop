import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserDaoTest {
    UserDao userDao;
    Customer eunnam;
    Customer other;

    @Before
    public void 초기화() {
        userDao = new UserDao();
        eunnam = new Customer("eunnam");
        userDao.add("eunnam", eunnam);
        other = new Customer("other");
        userDao.add("other", other);
    }

    @Test
    public void 이름을가지고가입할수있다() {
        Customer customer = userDao.add("eunnam", new Customer("eunnam"));
        assertThat(customer,is(eunnam));
    }
    @Test
    public void 이름을가지고손님정보를가져올수있다() {
        assertThat(userDao.get("eunnam"), is(eunnam));
        assertThat(userDao.get("other"),is(other));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 등록되지않은고객을조회한다() {
        userDao.get("bad");
    }
}
