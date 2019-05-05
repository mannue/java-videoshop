import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Video> db = new HashMap<>();

    public Video get(String title) {
        String lower = title.toLowerCase();
        if (!db.containsKey(lower)) throw new IllegalArgumentException();
        return db.get(lower);
    }


    public Video add(Video video) {
        String title = video.getTitle();
        try{
            return get(title);
        }catch (IllegalArgumentException e) {
            db.put(title,video);
            return video;
        }
    }
}
