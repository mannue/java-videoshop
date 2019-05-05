import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VideoManagerTest {
    VideoManager videoDao;
    Video fifa;
    Video ring;

    @Before
    public void 초기화() {
        videoDao = new VideoManager();
        fifa = new Video(VideoType.SPORT, "fifa", 1000, 10);
        videoDao.add(fifa);
        ring = new Video(VideoType.MOVIE, "ring", 500, 4);
        videoDao.add(ring);
    }

    @Test
    public void 비디오목록에서_이름_으로비디오를검색할수있다() {
        assertThat(videoDao.get("fifa"),is(fifa));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 비디오목록에_없는항목을_조회한다() {
        VideoManager videoDao = mock(VideoManager.class);
        when(videoDao.get("bad")).thenThrow(IllegalArgumentException.class);
        videoDao.get("bad");
    }

    @Test
    public void 대문자로_비디오목록을_검색해도_소문자검색도_동일한결과를_가진다() {
        assertThat(videoDao.get("fifa"),is(videoDao.get("FIFA")));
    }

    @Test
    public void 비디오목록에_비디오를_추가할수있다() {
        Video value = new Video(VideoType.SPORT, "fifa", 1000, 10);
        VideoManager videoDao = new VideoManager();
        Video res = videoDao.add(value);
        assertThat(res,is(value));

        Video video = new Video(VideoType.MOVIE, "ring", 500, 4);
        res = videoDao.add(video);
        assertThat(res,is(video));
    }
}
