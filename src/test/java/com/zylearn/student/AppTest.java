package com.zylearn.student;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testUtils() {
        int a = 100;
        int b = 200;
        Utils.print(Utils.add(a, b));
    }
}
