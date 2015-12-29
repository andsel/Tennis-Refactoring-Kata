
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (P1point == P2point)
        {
            if (P1point>=3)
                score = "Deuce";
            else
                score = scoreToLabel(P1point) + "-All";
        }

        if (P1point>P2point && P1point < 4)
        {
            P1res = scoreToLabel(P1point);
            P2res = scoreToLabel(P2point);
            score = P1res + "-" + P2res;
        }
        if (P2point>P1point && P2point < 4)
        {
            P1res = scoreToLabel(P1point);
            P2res = scoreToLabel(P2point);
            score = P1res + "-" + P2res;
        }
        
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage " + player1Name;
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage " + player2Name;
        }
        
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for " + player1Name;
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for " + player2Name;
        }
        return score;
    }
    
    //NB removed unused code

    public void wonPoint(String player) {
        if (player.equals("player1"))
            P1point++;
        else
            P2point++;
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