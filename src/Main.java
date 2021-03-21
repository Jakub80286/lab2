

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame Okno = new JFrame("Ping pong");
        Ustawienia panel;
        panel = new Ustawienia();
        Okno.add(panel);
        Okno.setResizable(false);
        Okno.setBackground(Color.green);
        Okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Okno.pack();
        Okno.setVisible(true);
        Okno.setLocationRelativeTo(null);

    }
}