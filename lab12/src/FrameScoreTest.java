import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameScoreTest {
    @Test
    void  test_Strike(){
        FrameScore frameScore = new FrameScore();
        frameScore.addScore(10);
        assertEquals(true, frameScore.isStrike());
        assertEquals(10, frameScore.getScore());
    }

    @Test
    void  test_NonStrike(){
        FrameScore frameScore = new FrameScore();
        frameScore.addScore(6, 3);
        assertEquals(false, frameScore.isStrike());
        assertEquals(9, frameScore.getScore());
    }

    @Test
    void test_AllPinButNotStrike(){
        FrameScore frameScore = new FrameScore();
        frameScore.addScore(5, 5);
        assertEquals(false, frameScore.isStrike());
        assertEquals(10, frameScore.getScore());
    }
}