package org.brush.bowling;

public class Game {
    private int itsScore = 0;

    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private Boolean firstThrow = true;

    public int score() {
        return itsScore;
    }

    public void add(int pins) {
        itsScore += pins;
        itsThrows[itsCurrentThrow++] = pins;
        adjustCurrentFrame();
    }

    private void adjustCurrentFrame() {
        if (firstThrow) {
            firstThrow = false;
        } else {
            firstThrow = true;
            itsCurrentFrame++;
        }
    }

    public int scoreForFrame(int theFrame) {
        int ball = 0;
        int score = 0;
        for (int i = 0; i < theFrame; i++) {
            int firstBall = itsThrows[ball++];
            int secondBall = itsThrows[ball++];
            int frameScore = firstBall + secondBall;
            if (frameScore == 10) {
                score += frameScore + itsThrows[ball];
            } else {
                score += frameScore;
            }
        }
        return score;
    }

    public int getCurrentFrame() {

        return itsCurrentFrame;
    }
}
