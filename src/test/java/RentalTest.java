import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class RentalTest {
    Video video;

    @Before
    public void texture() {
        video = new Video(VideoType.SPORT,"fifa",1000);
    }

    @Test
    public void 렌탈은비디오와대여기간을가진다() {
        Rental rental = new Rental(2,video);
        assertThat(rental, is(new Rental(2,video)));
        assertThat(rental, is(not(new Rental(3,video))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 렌탈에잘못된대여기간을입력한다() {
        new Rental(-1,video);
    }

    @Test
    public void 대여요금을알수있다() {
        Rental rental = new Rental(2, video);
        assertThat(rental.fee(), is(2000));
        Rental other = new Rental(3, video);
        assertThat(other.fee(), is(3000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 잘못된값과비교한다() {
        Rental rental = new Rental(2,video);
        rental.equals(null);
    }

    @Test
    public void 대여정보인비디오종류_제목_가격_대여기간을출력한다() {
        Rental rental = new Rental(2,video);
        Map<String,String> info = rental.getInfo();
        assertThat(info.get("type"), is(VideoType.SPORT.value()));
        assertThat(info.get("title"), is("fifa"));
        assertThat(info.get("price"), is(Integer.toString(1000)));
        assertThat(info.get("day"), is(Integer.toString(2)));
    }
}
