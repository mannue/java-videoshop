import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrderTest {
    @Test
    public void 주문은_비디오정보와_대여기간을_가진다() {
        Video video = new Video(VideoType.SPORT,"월드컵",1000,10);
        Order order = new Order(video, 10);
        assertThat(order.video(),is(video));
        assertThat(order.date(),is(10));
        assertThat(order , is(new Order(video,10)));
    }
}
