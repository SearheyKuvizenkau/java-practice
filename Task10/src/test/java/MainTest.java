import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MainTest {

    @Test
    public void inverse() {

        HashMap<Integer, String> hash = new HashMap<>();
        hash.put(1, "Sergey");
        hash.put(2, "Katya");
        hash.put(3, "Sergey");
        hash.put(4, "Aleksander");
        hash.put(5, "Aleksey");

        Map<String, Collection<Integer>> result = Main.inverse(hash);
        Assert.assertTrue(result.containsKey("Sergey"));
        Assert.assertTrue(result.containsKey("Katya"));
        Assert.assertTrue(result.containsKey("Aleksander"));
        Assert.assertTrue(result.containsKey("Aleksey"));
        Assert.assertTrue(result.containsValue(Arrays.asList(1, 3)));
        Assert.assertTrue(result.containsValue(Collections.singletonList(2)));
        Assert.assertTrue(result.containsValue(Collections.singletonList(4)));
        Assert.assertTrue(result.containsValue(Collections.singletonList(5)));


    }
}
