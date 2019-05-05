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

    @Test
    public void 비디오와_잘못된값을_비교시_다르다() {
        Video video = new Video(VideoType.SPORT,"fifa",1000,10);
        assertThat(video.equals(null),is(false));
    }

    @Test
    public void 비디오_최대빌린기간이_맞는지_확인하고_맞으면_요금을알려준() {
        Video video = new Video(VideoType.SPORT,"fifa",1000,10);
        assertThat(video.calculateAmount(8),is(8000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 최대기간보다_더많은기간을_입력하면_에러를_발생한다() {
        Video video = new Video(VideoType.SPORT,"fifa",1000,10);
        video.calculateAmount(11);
    }
}
