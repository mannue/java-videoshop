import java.util.Objects;

public class Video {
    private Integer day;
    private String type;
    private String title;
    private Integer price;

    public Video(String type, String title, Integer price) {
        this.type = type;
        this.title = title;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        Video video = (Video) obj;
        return type.equals(video.type) && title.equals(video.title) && price.equals(video.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, price);
    }

    @Override
    public String toString() {
        return "Video{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getToTal() {
        return price * day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}

