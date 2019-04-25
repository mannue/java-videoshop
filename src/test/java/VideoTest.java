import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class VideoTest {
    Video video;

    @Before
    public void initVideo() {
        video = new Video(VideoType.of("sport"), "fifa", 1000);
    }

    @Test
    public void 비디오는종류_제목_대여요금을가진다() {
        assertThat(video,is(new Video(VideoType.SPORT, "fifa", 1000)));
        Video video1 = new Video(VideoType.MOVIE,"ring",2000);
        assertThat(video,is(not(video1)));
    }

    @Test
    public void 종류_제목_대여요금이같으면같다() {
        assertThat(video, is(new Video(VideoType.SPORT,"fifa",1000)));
        assertThat(video, is(new Video(VideoType.SPORT,"FIFA", 1000)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 잘못된값으로비교한다() {
        video.equals(null);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void 잘못된대여가격입력하기() {
        new Video(VideoType.MOVIE,"ring",-1);
    }

    @Test
    public void 비디오장르_제목_대여요금정보를가져온다() {
        assertThat(video.getType(), is(VideoType.SPORT.value()));
        assertThat(video.getTitle(), is("fifa"));
        assertThat(video.getPrice(), is(1000));
    }
}
