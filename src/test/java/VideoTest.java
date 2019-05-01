import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class VideoTest {
    @Test
    public void 비디오는장르_제목_대여요금_최대대여일을가지고있다() {
        Video video = new Video(VideoType.SPORT,"fifa",1000,10);
        Video other = new Video(VideoType.MOVIE,"ring",10000,4);

        assertThat(video, is(new Video(VideoType.SPORT,"fifa",1000,10)));
        assertThat(video, is(not(other)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 비디오와잚못된값과비교해서에러가발생한다() {
        Video video = new Video(VideoType.SPORT,"fifa",1000,10);
        video.equals(null);
    }

    @Test
    public void 비디오최대빌린기간이맞는지확인하고맞으면요금을알려준() {
        Video video = new Video(VideoType.SPORT,"fifa",1000,10);
        assertThat(video.calculateAmount(8),is(8000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 최대기간보다더많은기간을입력하면에러를발생한다() {
        Video video = new Video(VideoType.SPORT,"fifa",1000,10);
        video.calculateAmount(11);
    }
}
