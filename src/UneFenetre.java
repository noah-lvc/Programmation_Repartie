import javax.swing.*;
import java.awt.*;

public class UneFenetre extends JFrame {
    private UnMobile sonMobile1;
    private UnMobile sonMobile2;
    private final int LARG=400, HAUT=250 , NBRLIG=2, NBRCOL=1;

    public UneFenetre() {
        setVisible(true);
        setSize(LARG, HAUT);
        Container leConteneur = getContentPane(); 
        leConteneur.setLayout (new GridLayout(NBRLIG, NBRCOL)); 

        sonMobile1 = new UnMobile(LARG, HAUT/NBRLIG);
        leConteneur.add(sonMobile1);
        sonMobile2 = new UnMobile(LARG, HAUT/NBRLIG);
        leConteneur.add(sonMobile2);
        Thread laTache1 = new Thread(sonMobile1);
        Thread laTache2 = new Thread(sonMobile2);
        laTache1.start();
        laTache2.start();
    }
}
