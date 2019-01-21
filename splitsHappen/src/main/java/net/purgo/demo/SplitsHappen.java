package net.purgo.demo;

public class SplitsHappen {
    public static int score(final String game) {
        int[] pins = new int[game.length()];
        for(int i = 0; i < pins.length; i++) {
            if(game.charAt(i) == 'X')
                pins[i] = 10;
            else if(game.charAt(i) == '-')
                pins[i] = 0;
            else if(game.charAt(i) == '/')
                pins[i] = 10 - pins[i-1];
            else
                pins[i] = game.charAt(i) - '0';
        }

        int score = 0;
        int ix = 0;
        for(int frame = 0; frame < 10; frame++) {
            int ball1 = pins[ix++];
            score += ball1;
            if(ball1 == 10) {
                score += pins[ix] + pins[ix+1];
            }
            else {
                final int ball2 = pins[ix++];
                score += ball2;
                if(ball1 + ball2 == 10) {
                    score += pins[ix];
                }
            }
        }

        return score;

    }
}
