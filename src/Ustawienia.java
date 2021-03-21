

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ustawienia extends JPanel implements Runnable{

    static Paletka paletka;
    static int SzerokoscGry = 1000;
    static int WysokoscGry = (int)(SzerokoscGry * (0.5555));
    static Dimension Okienko = new Dimension(SzerokoscGry, WysokoscGry);
    static int WielkoscPilki = 20;
    static int SzerokoscPaletki = paletka.paletka.getWidth();
    static int WysokoscPaletki =  paletka.paletka.getHeight();
    Thread watek;
    Image obraz;
    Graphics graphics;
    Random random;
    Paletka paletka1;
    Paletka paletka2;
    Pilka pilka;
    Wynik wynik;

    Ustawienia(){
        tworzPaletka();
        tworzPilke();
        wynik = new Wynik(SzerokoscGry, WysokoscGry);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(Okienko);

        watek = new Thread(this);
        watek.start();
    }

    public void tworzPilke() {
        random = new Random();
        pilka = new Pilka((SzerokoscGry /2)-(WielkoscPilki /2),random.nextInt(WysokoscGry - WielkoscPilki), WielkoscPilki, WielkoscPilki);
    }
    public void tworzPaletka() {
        paletka1 = new Paletka(0,(WysokoscGry /2)-(WysokoscPaletki /2), SzerokoscPaletki, WysokoscPaletki,1);
        paletka2 = new Paletka(SzerokoscGry - SzerokoscPaletki,(WysokoscGry /2)-(WysokoscPaletki /2), SzerokoscPaletki, WysokoscPaletki,2);
    }
    public void paint(Graphics g) {
        obraz = createImage(getWidth(),getHeight());
        graphics = obraz.getGraphics();
        rusyj(graphics);
        g.drawImage(obraz,0,0,this);
    }
    public void rusyj(Graphics g) {
        paletka1.draw(g);
        paletka2.draw(g);
        pilka.draw(g);
        wynik.draw(g);
        Toolkit.getDefaultToolkit().sync();

    }
    public void poruszanie() {
        paletka1.ruch();
        paletka2.ruch();
        pilka.move();
    }
    public void czyDotknal() {


        if (pilka.y <=0) {
            pilka.ZmianaY(-pilka.zmianay);
        }
        if(pilka.y >= WysokoscGry - WielkoscPilki) {
            pilka.ZmianaY(-pilka.zmianay);
        }

        if(pilka.intersects(paletka1)) {
            pilka.zmianax = Math.abs(pilka.zmianax);
            pilka.zmianax++;
            if(pilka.zmianay >0)
                pilka.zmianay++;
            else
                pilka.zmianay--;
            pilka.Zmianax(pilka.zmianax);
            pilka.ZmianaY(pilka.zmianay);
        }
        if(pilka.intersects(paletka2)) {
            pilka.zmianax = Math.abs(pilka.zmianax);
            pilka.zmianax++;
            if(pilka.zmianay >0)
                pilka.zmianay++;
            else
                pilka.zmianay--;
            pilka.Zmianax(-pilka.zmianax);
            pilka.ZmianaY(pilka.zmianay);
        }

        if(paletka1.y<=0)
            paletka1.y=0;
        if(paletka1.y >= (WysokoscGry - WysokoscPaletki))
            paletka1.y = WysokoscGry - WysokoscPaletki;
        if(paletka2.y<=0)
            paletka2.y=0;
        if(paletka2.y >= (WysokoscGry - WysokoscPaletki))
            paletka2.y = WysokoscGry - WysokoscPaletki;

        if(pilka.x <=0) {
            wynik.player2++;
            tworzPaletka();
            tworzPilke();
        }
        if(pilka.x >= SzerokoscGry - WielkoscPilki) {
            wynik.player1++;
            tworzPaletka();
            tworzPilke();
        }
    }
    public void run() {

        long czas = System.nanoTime();
        double licztik =60.0;
        double ns = 1000000000 / licztik;
        double delta = 0;
        while(true) {
            long ter = System.nanoTime();
            delta += (ter - czas)/ns;
            czas = ter;
            if(delta >=1) {
                poruszanie();
                czyDotknal();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            paletka1.keyPressed(e);
            paletka2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            paletka1.keyReleased(e);
            paletka2.keyReleased(e);
        }
    }
}