import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class VideoTest {

    @Test
    public void 비디오는종류__제목_대여요금_대여기간_대여금액을가진다() {
        Video video = new Video("sport", "fifa", 1000);
        assertThat(video,is(new Video("sport", "fifa", 1000)));
        Video video1 = new Video("movie","ring",2000);
        assertThat(video,is(not(video1)));
    }

    @Test
    public void 종류_제목_대여요금이같으면같다() {
        Video video = new Video("sport","fifa",1000);
        assertThat(video, is(new Video("sport","fifa",1000)));
    }

    @Test
    public void 대여기간을입력하면총대여금액을알수있다() {
        Video video = new Video("sport","fifa",1000);
        video.setDay(4);
        assertThat(video.getToTal() ,is(4000));
        video.setDay(5);
        assertThat(video.getToTal() ,is(5000));
    }
}
