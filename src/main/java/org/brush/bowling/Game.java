package org.brush.bowling;

public class Game {
    private int itsScore = 0;

    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private Boolean firstThrowInFrame = true;
    private int firstThrow=0;
    private int secondThrow=0;
    private int ball=0;

    public int score() {
        return scoreForFrame(getCurrentFrame() - 1);
    }

    public void add(int pins) {
        itsScore += pins;
        itsThrows[itsCurrentThrow++] = pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrowInFrame) {
            if (pins == 10) {
                itsCurrentFrame++;
            } else {
                firstThrowInFrame = false;
            }

        } else {
            firstThrowInFrame = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame=Math.min(11,itsCurrentFrame);
    }

    public int scoreForFrame(int theFrame) {
        ball = 0;
        int score = 0;
        for (int i = 0; i < theFrame; i++) {
            firstThrow = itsThrows[ball];
            if(strike())
            {
                ball++;
                score += 10+nextTowBalls();
            }else
            {
                score += handleSecondThrow();
            }

        }
        return score;
    }

    private int nextTowBalls() {
        return itsThrows[ball]+itsThrows[ball +1];
    }

    private boolean strike() {
        return itsThrows[ball] ==10;
    }

    private int handleSecondThrow() {
        int score = 0;
        secondThrow = itsThrows[ball+1];
        int frameScore = firstThrow + secondThrow;
        if (spare()) {
            ball+=2;
            score += 10 + nextBall();
        } else {
            ball+=2;
            score += frameScore;
        }
        return score;
    }

    private int nextBall() {
        return itsThrows[ball];
    }

    private boolean spare()
    {
        return (itsThrows[ball]+itsThrows[ball+1])==10;
    }

    public int getCurrentFrame() {

        return itsCurrentFrame;
    }
}
