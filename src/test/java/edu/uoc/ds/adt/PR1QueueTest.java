package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR1QueueTest {
    PR1Queue pr1q;

    private void fillQueue() {
        for (int x = 0; x < 15; x++) {
            pr1q.add(Utils.calculateValue(x));
        }
    }

    @Before
    public void setUp() {
        this.pr1q = new PR1Queue();

        assertNotNull(this.pr1q.getQueue());
        fillQueue();
    }

    @After
    public void release() {
        this.pr1q = null;
    }


    @org.junit.Test
    public void queueTest() {
        assertEquals(this.pr1q.CAPACITY - 1, this.pr1q.getQueue().size());

        assertEquals(Integer.valueOf(2), pr1q.poll());
        assertEquals(Integer.valueOf(6), pr1q.poll());
        assertEquals(Integer.valueOf(12), pr1q.poll());
        assertEquals(Integer.valueOf(20), pr1q.poll());
        assertEquals(Integer.valueOf(30), pr1q.poll());
        assertEquals(Integer.valueOf(42), pr1q.poll());
        assertEquals(Integer.valueOf(56), pr1q.poll());
        assertEquals(Integer.valueOf(72), pr1q.poll());
        assertEquals(Integer.valueOf(90), pr1q.poll());
        assertEquals(Integer.valueOf(110), pr1q.poll());
        assertEquals(Integer.valueOf(132), pr1q.poll());
        assertEquals(Integer.valueOf(156), pr1q.poll());
        assertEquals(Integer.valueOf(182), pr1q.poll());
        assertEquals(Integer.valueOf(210), pr1q.poll());
        assertEquals(Integer.valueOf(240), pr1q.poll());


        assertEquals(0, this.pr1q.getQueue().size());
    }

}