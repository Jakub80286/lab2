

import java.awt.*;
import java.util.*;

public class Pilka extends Rectangle{

    Random random;
    int zmianax;
    int zmianay;
    int predkosc = 2;

    Pilka(int x, int y, int szerokosc, int wysokosc){
        super(x,y,szerokosc, wysokosc);
        random = new Random();
        int ktoraStrona = random.nextInt(2);
        if(ktoraStrona == 0)
            ktoraStrona--;
        Zmianax(ktoraStrona * predkosc);

        int randomYStrona = random.nextInt(2);
        if(randomYStrona == 0)
            randomYStrona--;
        ZmianaY(randomYStrona * predkosc);

    }

    public void Zmianax(int randomXStrona) {
        zmianax = randomXStrona;
    }
    public void ZmianaY(int randomYStrona) {
        zmianay = randomYStrona;
    }
    public void move() {
        x += zmianax;
        y += zmianay;
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, height, width);
    }
}