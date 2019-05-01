import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RentalTest {
    @Test
    public void 렌탈정보에는_요금_주정보_를가질수있다() {
        Rental rental = new Rental(10000,new Order("fifa",10));
        assertThat(rental, is(new Rental(10000,new Order("fifa",10))));
    }

    @Test
    public void 렌탈은_주문정보_를여러개가질수있다() {
        Rental rental = new Rental(20000, new Order("fifa",10),new Order("ring",5));
        assertThat(rental.getOrderCount(), is(2));
    }
}
