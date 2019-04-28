import org.junit.Test;

import java.util.function.BiConsumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VideoShopTest {
    private VideoShop mockVideoShop(BiConsumer biConsumer) {
        UserDao userDao = mock(UserDao.class);
        VideoDao videoDao = mock(VideoDao.class);
        biConsumer.accept(userDao, videoDao);
        return new VideoShop(userDao, videoDao);
    }

    @Test
    public void 고객은한개의비디오의예상금액을알수있다() {
        BiConsumer<UserDao, VideoDao> consumer = (x, y) -> {
            when(x.get("eunnam")).thenReturn(new Customer("eunnam"));
            when(y.get("fifa")).thenReturn(new Video(VideoType.SPORT,"fifa",1000,10));
        };
        VideoShop videoShop = mockVideoShop(consumer);
        Integer expectedAmount = videoShop.expectedAmount(new Order("fifa", 10));
        assertThat(expectedAmount,is(10000));
    }

    @Test
    public void 고객은여러개의비디오의예상금액을알수있다() {
        BiConsumer<UserDao, VideoDao> consumer = (x, y) -> {
            when(x.get("eunnam")).thenReturn(new Customer("eunnam"));
            when(y.get("fifa")).thenReturn(new Video(VideoType.SPORT,"fifa",1000,10));
            when(y.get("ring")).thenReturn(new Video(VideoType.MOVIE,"ring",2000,5));
        };

        VideoShop videoShop = mockVideoShop(consumer);
        Integer expectedAmount = videoShop.expectedAmount(new Order("fifa", 10), new Order("ring", 5));
        assertThat(expectedAmount, is(20000));

    }
}
