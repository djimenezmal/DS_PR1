package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR1StackTest {

    PR1Stack pr1s;

    private void fillStack() {
        for (int x = 0; x < 15; x++) {
            pr1s.push(Utils.calculateValue(x));
        }
    }

    @Before
    public void setUp() {
        this.pr1s = new PR1Stack();
        assertNotNull(this.pr1s.getStack());
        this.fillStack();
    }

    @After
    public void release() {
        this.pr1s = null;
    }


    @org.junit.Test
    public void stackTest() {

        assertEquals(this.pr1s.CAPACITY-1, this.pr1s.getStack().size());

        assertEquals(Integer.valueOf(240), pr1s.pop());
        assertEquals(Integer.valueOf(210), pr1s.pop());
        assertEquals(Integer.valueOf(182), pr1s.pop());
        assertEquals(Integer.valueOf(156), pr1s.pop());
        assertEquals(Integer.valueOf(132), pr1s.pop());
        assertEquals(Integer.valueOf(110), pr1s.pop());
        assertEquals(Integer.valueOf(90), pr1s.pop());
        assertEquals(Integer.valueOf(72), pr1s.pop());
        assertEquals(Integer.valueOf(56), pr1s.pop());
        assertEquals(Integer.valueOf(42), pr1s.pop());
        assertEquals(Integer.valueOf(30), pr1s.pop());
        assertEquals(Integer.valueOf(20), pr1s.pop());
        assertEquals(Integer.valueOf(12), pr1s.pop());
        assertEquals(Integer.valueOf(6), pr1s.pop());
        assertEquals(Integer.valueOf(2), pr1s.pop());

        assertEquals(0, this.pr1s.getStack().size());
    }
}