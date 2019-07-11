import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
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
        Assert.assertEquals(result.get("Sergey"), Arrays.asList(1,3));
        Assert.assertEquals(result.get("Katya"), Collections.singletonList(2));
        Assert.assertEquals(result.get("Aleksander"), Collections.singletonList(4));
        Assert.assertEquals(result.get("Aleksey"), Collections.singletonList(5));

    }
}

