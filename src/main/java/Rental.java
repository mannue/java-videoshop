import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Rental {
    private Integer day;
    private Video video;

    public Rental(Integer day, Video video) {
        if (day < 1) throw new IllegalArgumentException();
        this.day = day;
        this.video = video;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rental) {
            Rental rental = (Rental) obj;
            return day.equals(rental.day) &&
                    Objects.equals(video, rental.video);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, video);
    }

    public Integer fee() {
        return day * video.getPrice();
    }

    public Map<String, String> getInfo() {
        return new HashMap<String, String>() {{
            put(Key.TYPE.value(), video.getType());
            put(Key.TITILE.value(), video.getTitle());
            put(Key.PRICE.value(), Integer.toString(video.getPrice()));
            put(Key.DAY.value(), Integer.toString(day));
        }};
    }
}
