import java.util.Objects;

public enum VideoType {
    SPORT("sport") , MOVIE("movie"), DOCUMENTARY("documentary");

    private String type;

    VideoType(String type) {
        this.type = type;
    }

    public static VideoType of(String type) {
        for (VideoType videoType : VideoType.values()) {
            if (Objects.equals(videoType.type.toLowerCase(),type.toLowerCase())) {
                return videoType;
            }
        }
        throw new IllegalArgumentException();
    }

    public String value() {
        return type;
    }
}
