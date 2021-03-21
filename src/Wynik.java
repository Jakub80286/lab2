

import java.awt.*;

public class Wynik extends Rectangle{

    static int SzerokoscGry;
    static int WysokoscGry;
    int player1;
    int player2;


    Wynik(int SzerokoscGry, int WysokoscGry){
        Wynik.SzerokoscGry = SzerokoscGry;
        Wynik.WysokoscGry = WysokoscGry;

    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.PLAIN,60));

        g.drawLine(SzerokoscGry /2, 0, SzerokoscGry /2, WysokoscGry);

        g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (SzerokoscGry /2)-85, 50);
        g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (SzerokoscGry /2)+20, 50);
    }
}