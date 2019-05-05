import org.junit.Test;

import java.util.function.BiConsumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class VideoShopTest {
    private VideoShop mockDao(BiConsumer biConsumer) {
        CustomerManager customerDao = mock(CustomerManager.class);
        VideoManager videoDao = mock(VideoManager.class);
        biConsumer.accept(customerDao, videoDao);
        return new VideoShop(customerDao, videoDao);
    }

    @Test
    public void 고객은_한개의비디오를_빌릴경우_예상금액을_알수있다() {
        BiConsumer<CustomerManager, VideoManager> consumer = (x, y) -> {
            when(x.get("eunnam")).thenReturn(new Customer("eunnam"));
            when(y.get("fifa")).thenReturn(new Video(VideoType.SPORT,"fifa",1000,10));
        };
        VideoShop videoShop = mockDao(consumer);
        Integer expectedAmount = videoShop.expectedAmount(new Order(new Video(VideoType.SPORT,"fifa",1000,10), 10));
        assertThat(expectedAmount,is(10000));
    }

    @Test
    public void 고객은_여러개의_비디오를_빌릴경우_예상금액을_알수있다() {
        BiConsumer<CustomerManager, VideoManager> consumer = (x, y) -> {
        };
        VideoShop videoShop = mockDao(consumer);
        Integer expectedAmount = videoShop.expectedAmount(new Order(new Video(VideoType.SPORT, "월드컵", 1000, 10), 10),
                new Order(new Video(VideoType.MOVIE, "링",2000,5), 5));
        assertThat(expectedAmount, is(20000));
    }

    @Test
    public void 비디오이름을_가지고_비디오정보를_가져올수있다() {
        VideoManager mock = mock(VideoManager.class);
        Video video = new Video(VideoType.SPORT, "fifa", 10000, 10);
        when(mock.get("fifa")).thenReturn(video);
        VideoShop videoShop = new VideoShop(new CustomerManager(), mock);
        assertThat(videoShop.findVideo("fifa"),is(video));
    }

    @Test
    public void 고객은_비디오를_빌릴수있으며_정상적인경우_사용자정보에_빌릴정보가_있다() {
        VideoManager videoManagerMock = mock(VideoManager.class);
        CustomerManager customerManagerMock = mock(CustomerManager.class);
        Customer customerMock = mock(Customer.class);
        when(videoManagerMock.get("fifa")).thenReturn(new Video(VideoType.SPORT,"fifa",1000,10));
        when(customerManagerMock.get(anyString())).thenReturn(customerMock);
        VideoShop videoShop = new VideoShop(customerManagerMock, videoManagerMock);
        Order order = new Order(videoShop.findVideo("fifa"), 5);
        videoShop.rent("mannue", order);
        verify(customerMock).register(order);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 고객이_잘못된비디오를_빌릴려고하면_에러가발생한다() {
        CustomerManager customerManagerMock = mock(CustomerManager.class);
        Customer customerMock = mock(Customer.class);
        when(customerManagerMock.get(anyString())).thenReturn(customerMock);
        VideoShop videoShop = new VideoShop(customerManagerMock, new VideoManager());
        videoShop.rent("mannue",new Order(null,0));
    }
}
