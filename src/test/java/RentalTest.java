import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RentalTest {
    @Test
    public void 렌탈정보에는_요금_주문정보를_가질수있다() {
        Video video = new Video(VideoType.SPORT,"월드컵",1000,10);
        Rental rental = new Rental(10000,new Order(video,10));
        assertThat(rental, is(new Rental(10000,new Order(video,10))));
    }

    @Test
    public void 렌탈은_여러개주문정보_주문에_따른_총금액을_가질수있으며_order의개수를알수있다() {
        Video video = new Video(VideoType.SPORT,"월드컵",1000,10);
        Video vide1 = new Video(VideoType.MOVIE,"링",2000,5);
        Rental rental = new Rental(20000, new Order(video,10),new Order(vide1,5));
        assertThat(rental.getOrderCount(), is(2));
    }
}
