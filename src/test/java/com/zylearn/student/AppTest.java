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

    @Test
    public void testToStringBuilder() {
        ToStringBuilder builder = new GenerateToStringBuilder();
        ToStringDirector director = new ToStringDirector();
        Person person = new Person("张三",40);
        String ret = director.doBuild(builder,person);
        System.out.println(ret);
    }
}
