import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;

public class QueuelmplTest {

    @Test
    public void add() {

        Queuelmpl<Integer> que = new Queuelmpl<>();

        que.add(5);
        que.add(6);
        que.add(7);
        que.add(8);
        que.add(9);

        Assert.assertSame(5, que.peek());

        que.pop();

        Assert.assertSame(6, que.peek());

    }

    @Test
    public void peek() {

        Queuelmpl<Integer> que = new Queuelmpl<>();

        que.add(5);
        que.add(6);
        que.add(7);
        que.add(8);
        que.add(9);


        Assert.assertSame(5, que.peek());
        Assert.assertNotNull(que.peek());

        que.pop();
        que.pop();
        que.pop();
        que.pop();
        que.pop();

        Assert.assertNull(que.peek());

    }

    @Test
    public void pop() {

        Queuelmpl<Integer> que = new Queuelmpl<>();

        que.add(5);
        que.add(6);
        que.add(7);
        que.add(8);
        que.add(9);

        que.pop();

        Assert.assertSame(6, que.peek());
        Assert.assertNotNull(que.pop());

        que.pop();
        que.pop();
        que.pop();
        que.pop();

        Assert.assertNull(que.pop());

    }

    @Test
    public void addAll() {

        Queuelmpl<Integer> que = new Queuelmpl<>();
        Queuelmpl<Integer> que1 = new Queuelmpl<>();

        que.add(5);
        que.add(6);
        que.add(7);
        que.add(8);
        que.add(9);

        que1.add(11);
        que1.add(10);

        que.addAll(que1);

        que.pop();
        que.pop();
        que.pop();
        que.pop();
        que.pop();

        Assert.assertSame(11, que.peek());

        que.pop();

        Assert.assertSame(10, que.peek());

        que.pop();

        Assert.assertNull(que.peek());

    }

    @Test
    public void indexOff() {
        Queuelmpl<Integer> que = new Queuelmpl<>();
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x > 0;
            }
        };

        que.add(1);

        Assert.assertEquals(0, que.indexOff(predicate));

        que.pop();

        que.add(-1);

        Assert.assertEquals(-1, que.indexOff(predicate));

    }
}
