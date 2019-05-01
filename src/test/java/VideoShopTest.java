import org.junit.Test;

import java.util.function.BiConsumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class VideoShopTest {
    private VideoShop mockVideoShop(BiConsumer biConsumer) {
        CustomerDao customerDao = mock(CustomerDao.class);
        VideoDao videoDao = mock(VideoDao.class);
        biConsumer.accept(customerDao, videoDao);
        return new VideoShop(customerDao, videoDao);
    }

    @Test
    public void 고객은한개의비디오의예상금액을알수있다() {
        BiConsumer<CustomerDao, VideoDao> consumer = (x, y) -> {
            when(x.get("eunnam")).thenReturn(new Customer("eunnam"));
            when(y.get("fifa")).thenReturn(new Video(VideoType.SPORT,"fifa",1000,10));
        };
        VideoShop videoShop = mockVideoShop(consumer);
        Integer expectedAmount = videoShop.expectedAmount(new Order("fifa", 10));
        assertThat(expectedAmount,is(10000));
    }

    @Test
    public void 고객은여러개의비디오의예상금액을알수있다() {
        BiConsumer<CustomerDao, VideoDao> consumer = (x, y) -> {
            when(x.get("eunnam")).thenReturn(new Customer("eunnam"));
            when(y.get("fifa")).thenReturn(new Video(VideoType.SPORT,"fifa",1000,10));
            when(y.get("ring")).thenReturn(new Video(VideoType.MOVIE,"ring",2000,5));
        };

        VideoShop videoShop = mockVideoShop(consumer);
        Integer expectedAmount = videoShop.expectedAmount(new Order("fifa", 10), new Order("ring", 5));
        assertThat(expectedAmount, is(20000));

    }

    @Test
    public void 비디오샾은_등록되지않은사용자를가입하고_사용자정보를준다() {
        BiConsumer<CustomerDao, VideoDao> consumer = (x, y) -> {
            when(x.get("no")).thenThrow(IllegalArgumentException.class);
        };
        VideoShop videoShop = mockVideoShop(consumer);
         Customer customer =videoShop.registerCustomer("no");
         assertThat(customer, is(new Customer("no")));
    }

    @Test
    public void 비디오샾은_비디오를등록하고비디오정보를넘겨준() {
        VideoDao mock = mock(VideoDao.class);
        CustomerDao customerDao = new CustomerDao();
        VideoShop videoShop = new VideoShop(customerDao, mock);
        Video fifa = new Video(VideoType.SPORT, "fifa", 1000, 10);
        videoShop.registerVideo("fifa",fifa);
        verify(mock, times(1)).add("fifa", fifa);
    }
}
