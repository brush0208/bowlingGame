package org.brush.bowling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {


    private Game game=null;

    @Before
    public void setUp()
    {
        game=new Game();
    }

    @Test
    public void testTowThrows()
    {
        game.add(5);
        game.add(4);
        assertEquals("get score",9,game.score());
        assertEquals("current frame",2,game.getCurrentFrame());
    }

    @Test
    public void testFourThrowsNoMark()
    {
        game.add(5);
        game.add(4);
        game.add(7);
        game.add(2);
        assertEquals("get score",18,game.score());
        assertEquals("1 frame score",9,game.scoreForFrame(1));
        assertEquals("2 frame score",18,game.scoreForFrame(2));
        assertEquals("current frame",3,game.getCurrentFrame());
    }

    @Test
    public void testSimpleSpare()
    {
        game.add(3);
        game.add(7);
        game.add(3);
        assertEquals("simpleSpare",13,game.scoreForFrame(1));
        assertEquals("simpleSpare score",13,game.score());
    }

    @Test
    public void TestSimpleFrameAfterSpare()
    {
        game.add(3);
        game.add(7);
        game.add(3);
        game.add(2);
        assertEquals("frame 1",13,game.scoreForFrame(1));
        assertEquals("frame 2",18,game.scoreForFrame(2));
        assertEquals("score",18,game.score());
    }
    @Test
    public void test()
    {
        game.add(10);
        game.add(3);
        game.add(6);
        assertEquals("score frame 1",19,game.scoreForFrame(1));
        assertEquals("score ",28,game.score());
        assertEquals("current frame",3,game.getCurrentFrame());

    }

    @Test
    public void testPerfactGame()
    {
        for(int i=0;i<12;i++)
        {
            game.add(10);
        }
        assertEquals("score",300,game.score());
        assertEquals("score frame 1",30,game.scoreForFrame(1));
        assertEquals("score frame 2",60,game.scoreForFrame(2));
        assertEquals("current frame",11,game.getCurrentFrame());
    }

    @Test
    public void testEndOfArray()
    {
        for(int i=0;i<9;i++)
        {
            game.add(0);
            game.add(0);
        }
        game.add(2);
        game.add(8);
        game.add(10);
        assertEquals("endOfArray",20, game.score());
    }
}