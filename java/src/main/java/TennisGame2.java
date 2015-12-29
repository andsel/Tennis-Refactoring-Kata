
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
        } else {
            if (P1point >= 4 || P2point >= 4) {
                int distance = P1point - P2point;
                String forwardPlayer = distance > 0 ? player1Name : player2Name;
                if (Math.abs(distance) == 1) {
                    score = "Advantage " + forwardPlayer;
                } else if (Math.abs(distance) >= 2) {
                    score = "Win for " + forwardPlayer;
                }
            } else {
                P1res = scoreToLabel(P1point);
                P2res = scoreToLabel(P2point);
                score = P1res + "-" + P2res;
            }
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