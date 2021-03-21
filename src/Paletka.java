

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Paletka extends Rectangle{

    int id;
    int yPredkosc;
    int szybkosc = 10;
    static BufferedImage paletka= new Foto().getZdjecia("czerwonapaletka.png");
    static BufferedImage czarna=new Foto().getZdjecia("czarnapaletka.png");


    public Paletka(int x, int y, int szerokoscpaletki, int wysokoscpaletki, int id){
        super(x,y, szerokoscpaletki, wysokoscpaletki);
        this.id =id;

    }

    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W) {
                    setYDirection(-szybkosc);
                }
                if(e.getKeyCode()==KeyEvent.VK_S) {
                    setYDirection(szybkosc);
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP) {
                    setYDirection(-szybkosc);
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN) {
                    setYDirection(szybkosc);
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W) {
                    setYDirection(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_S) {
                    setYDirection(0);
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP) {
                    setYDirection(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN) {
                    setYDirection(0);
                }
                break;
        }
    }
    public void setYDirection(int yDirection) {
        yPredkosc = yDirection;
    }
    public void ruch() {
        y= y + yPredkosc;
    }
    public void draw(Graphics g) {

        if(id==1 ){
            g.drawImage(paletka,x,y,null);
        }
        else{
            g.drawImage(czarna,x,y,null);
        }



    }
}