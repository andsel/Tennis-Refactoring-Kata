
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        //== checks the instance id
        if (playerName.equals("player1"))
            m_score1++;
        else
            m_score2++;
    }

    public String getScore() {
        String score;
        if (m_score1==m_score2)
        {
            if (m_score1 <= 2)
                score = scoreToLabel(m_score1) + "-All";
            else
                score = "Deuce";
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int scoreDistance = m_score1-m_score2;
            final String prefix = Math.abs(scoreDistance) == 1 ? "Advantage " : "Win for ";
            final String playerName = m_score1 > m_score2 ? player1Name : player2Name;
            score = prefix + playerName;
        }
        else
        {
            score = scoreToLabel(m_score1) + "-" + scoreToLabel(m_score2);
        }
        return score;
    }

    private String scoreToLabel(int score) {
        switch(score)
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
