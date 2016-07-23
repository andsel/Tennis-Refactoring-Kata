
public class TennisGame1 implements TennisGame {

    class Score implements Comparable<Score> {
        private int value = 0;

        void markPoint() {
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

        public int compareTo(Score o) {
            return o.value - value;
        }
    }

    class Player implements Comparable<Player> {
        private Score score = new Score();
        final String name;

        Player(String name) {
            this.name = name;
        }

        void wonPoint() {
            score.markPoint();
        }

        boolean hasScoredAtLeast3Points() {
            return score.value > 3;
        }

        @Override
        public String toString() {
            return name;
        }

        public int compareTo(Player o) {
            return o.score.compareTo(score);
        }
    }

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.name))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String getScore() {
        int res = player2.compareTo(player1);
        if (res == 0)
        {
            if (player1.score.value >= 3) {
                return "Deuce";
            }
            return player1.score + "-All";
        }
        if (player1.hasScoredAtLeast3Points() || player2.hasScoredAtLeast3Points())
        {
            Player advantagePlayer = res > 0 ? player2 : player1;
            String winType = Math.abs(res) == 1 ? "Advantage " : "Win for ";
            return winType + advantagePlayer;
        }
        return player1.score + "-" + player2.score;
    }
}
