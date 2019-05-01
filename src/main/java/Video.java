import java.util.Objects;

public class Video {
    private VideoType type;
    private String title;
    private Integer price;
    private Integer maxDate;

    public Video(VideoType type, String title, Integer price, Integer maxDate) {
        this.type = type;
        this.title = title;
        this.price = price;
        this.maxDate = maxDate;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Video) {
            Video video = (Video) obj;
            return type == video.type &&
                    Objects.equals(title, video.title) &&
                    Objects.equals(price, video.price) &&
                    Objects.equals(maxDate, video.maxDate);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, price, maxDate);
    }


    public Integer calculateAmount(Integer date) {
        if(date > maxDate) throw new IllegalArgumentException();
        return price * date;
    }

    @Override
    public String toString() {
        return "Video{" +
                "type=" + type.value() +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", maxDate=" + maxDate +
                '}';
    }
}
