import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RentalTest {
    @Test
    public void 렌탈정보에는요금과주정보를가질수있다() {
        Rental rental = new Rental(10000,new Order("fifa",10));
        assertThat(rental, is(new Rental(10000,new Order("fifa",10))));
    }

    @Test
    public void 렌탈은주문정보를여러개가질수있다() {
        Rental rental = new Rental(20000);
        Integer count = rental.add(new Order("fifa",10));
        count = rental.add(new Order("ring",5));
        assertThat(count, is(2));
    }
}
