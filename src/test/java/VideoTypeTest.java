import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VideoTypeTest {
    @Test
    public void 입력값으로_장르를_가져온다() {
        VideoType type = VideoType.of("스포츠");
        assertThat(type, is(VideoType.SPORT));
        assertThat(type.value(), is("스포츠"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 잘못된_입력값으로_값_변환시_에러가_발생한다() {
        VideoType.of("test");
    }
}
