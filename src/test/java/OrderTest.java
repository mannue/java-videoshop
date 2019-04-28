import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrderTest {
    @Test
    public void 주문은비디오이름과대여기간을가진다() {
        Order order = new Order("fifa", 10);
        assertThat(order.title(),is("fifa"));
        assertThat(order.date(),is(10));
        assertThat(order , is(new Order("fifa",10)));
    }
}
