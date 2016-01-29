
public class TennisGame1 implements TennisGame {

    class Player {
        private int m_score = 0;
        public final String name;

        Player(String name) {
            this.name = name;
        }

        void wonPoint() {
            m_score++;
        }

        int score() {
            return m_score;
        }

        Player vantage(Player opposite) {
            return m_score > opposite.score() ? this : opposite;
        }

        private String scoreToLabel() {
            switch(m_score)
            {
                case 0:
                    return "Love";
                case 1:
                    return "Fifteen";
                case 2:
                    return "Thirty";
                case 3:
                    return "Forty";
                default:
                    return "";
            }
        }
     }

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1.wonPoint();
        } else {
            player2.wonPoint();
        }
    }

    public String getScore() {
        if (player1.score() == player2.score()) {
            if (player1.score() <= 2) {
                return player1.scoreToLabel() + "-All";
            }
            return "Deuce";
        }
        if (player1.score() >= 4 || player2.score() >= 4) {
            final String prefix = advantageType(player1, player2);
            final Player advantaged = player1.vantage(player2);
            return prefix + advantaged.name;
        }
        return player1.scoreToLabel() + "-" + player2.scoreToLabel();
    }

    String advantageType(Player player1, Player player2) {
        int scoreDistance = player1.score() - player2.score();
        return Math.abs(scoreDistance) == 1 ? "Advantage " : "Win for ";
    }
}
