import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VideoDaoTest {
    VideoDao videoDao;
    Video fifa;
    Video ring;

    @Before
    public void 초기화() {
        videoDao = new VideoDao();
        fifa = new Video(VideoType.SPORT, "fifa", 1000, 10);
        videoDao.add("fifa",fifa);
        ring = new Video(VideoType.MOVIE, "ring", 500, 4);
        videoDao.add("ring",ring);
    }

    @Test
    public void 비디오목록에서이름으로비디오를검색한() {
        assertThat(videoDao.get("fifa"),is(fifa));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 비디오목록에없는항목을조회한다() {
        VideoDao videoDao = mock(VideoDao.class);
        when(videoDao.get("bad")).thenThrow(IllegalArgumentException.class);
        videoDao.get("bad");
    }

    @Test
    public void 대문자로비디오목록을검색해도소문자검색도동일한결과를가져온다() {
        assertThat(videoDao.get("fifa"),is(videoDao.get("FIFA")));
    }

    @Test
    public void 비디오목록에비디오를추가할수있다() {
        Video value = new Video(VideoType.SPORT, "fifa", 1000, 10);
        VideoDao videoDao = new VideoDao();
        Video res = videoDao.add("fifa",value);
        assertThat(res,is(value));

        Video video = new Video(VideoType.MOVIE, "ring", 500, 4);
        res = videoDao.add("ring",video);
        assertThat(res,is(video));
    }
}
