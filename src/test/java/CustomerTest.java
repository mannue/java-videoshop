import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class CustomerTest {
    Customer customer;

    @Before
    public void init() {
        customer = new Customer("eunnam");
    }

    @Test
    public void 고객은이름을가지고있다() {
//        assertThat(customer.name,is(new Customer("eunnam").name));
//        assertThat(customer.name,is(not(new Customer("different").name)));
        assertThat(customer, is(new Customer("eunnam")));
        assertThat(customer, is(not(new Customer("different"))));
    }

    @Test
    public void 고객의이름은대소문자를구별하지않는다() {
        assertThat(customer, is(new Customer("EUNNAM")));
    }

    @Test
    public void 고객은여러개의비디오를대여할수있다() {
        registerRentalInCustomer(new Video(VideoType.SPORT,"fifa",1000),2);
        assertThat(customer.getRentalCount(),is(1));
        assertThat(customer.getRentalPrice(),is(2000));

        registerRentalInCustomer(new Video(VideoType.MOVIE,"ring",2000),1);

        assertThat(customer.getRentalCount(),is(2));
        assertThat(customer.getRentalPrice(),is(4000));
    }
    private void registerRentalInCustomer(Video video, Integer day) {
        Map<String, String> value = makeRentalInfo(video, day);
        Rental rental = mock(Rental.class);
        when(rental.getInfo()).thenReturn(value);
        when(rental.fee()).thenReturn(video.getPrice() * day);
        customer.register(rental);
    }
    private Map<String,String> makeRentalInfo(Video video, Integer day) {
        Map<String,String> value = new HashMap<>();
        value.put(Key.TYPE.value(),video.getType());
        value.put(Key.TITILE.value(),video.getTitle());
        value.put(Key.PRICE.value(),Integer.toString(video.getPrice()));
        value.put(Key.DAY.value(),Integer.toString(day));
        return value;
    }

    @Test
    public void 고객이름가져오기() {
        assertThat(customer.getName(), is("eunnam"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 잘못된고객을비교한다() {
        customer.equals(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 잘못된Rental값저장() {
        customer.register(null);
    }


}
