import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VideoTypeTest {
    @Test
    public void 장가져오기() {
        VideoType type = VideoType.of("스포츠");
        assertThat(type, is(VideoType.SPORT));
        assertThat(type.value(), is("스포츠"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 잘못된장르선택하기() {
        VideoType.of("test");
    }
}
