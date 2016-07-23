
public class TennisGame1 implements TennisGame {

    class Score {
        private int value = 0;

        void wonPoint() {
            value++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Score)) return false;

            Score score = (Score) o;

            return value == score.value;

        }

        @Override
        public int hashCode() {
            return value;
        }

        @Override
        public String toString() {
            switch (value)
            {
                case 0:
                    return "Love";
                case 1:
                    return "Fifteen";
                case 2:
                    return "Thirty";
                default:
                    return "Forty";
            }
        }
    }


    private Score score1 = new Score();
    private Score score2 = new Score();
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            score1.wonPoint();
        else
            score2.wonPoint();
    }

    public String getScore() {
        String score = "";
        if (score1.equals(score2))
        {
            if (score1.value <= 2) {
                score = score1 + "-All";
            } else {
                score = "Deuce";
            }
        }
        else if (score1.value > 3 || score2.value > 3)
        {
            int minusResult = score1.value - score2.value;
            if (minusResult==1) score ="Advantage " + player1Name;
            else if (minusResult ==-1) score ="Advantage " + player2Name;
            else if (minusResult>=2) score = "Win for " + player1Name;
            else score ="Win for " + player2Name;
        }
        else
        {
            score = score1 + "-" + score2;
        }
        return score;
    }
}
