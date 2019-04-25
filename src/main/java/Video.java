import java.util.Objects;

public class Video {
    private VideoType type;
    private String title;
    private Integer price;

    public Video(VideoType type, String title, Integer price) {
        this.type = type;
        this.title = title;
        if (price < 1) throw new IllegalArgumentException();
        this.price = price;
    }

    public String getType() {
        return type.value();
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Video) {
            Video video = (Video) obj;
            return type.equals(video.type) &&
                    Objects.equals(title.toLowerCase(), video.title.toLowerCase()) &&
                    price.equals(video.price);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, price);
    }

    @Override
    public String toString() {
        return "Video{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

}

