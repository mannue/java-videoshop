import java.util.HashMap;
import java.util.Map;

public class CustomerDao {
    private Map<String, Customer> db = new HashMap<>();

    public Customer get(String name) {
        String lower = name.toLowerCase();
        if (!db.containsKey(lower)) throw new IllegalArgumentException();
        return db.get(lower);
    }

    public Customer add(String name, Customer customer) {
        try {
            return get(name);
        } catch (IllegalArgumentException e) {
            db.put(name, customer);
            return customer;
        }
    }
}
