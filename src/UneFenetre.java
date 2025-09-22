import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class UneFenetre extends JFrame {
    private ArrayList<UnMobile> mobiles;
    private ArrayList<Thread> threads;
    private UnMobile mobile;
    private final int LARG=400, HAUT= 1000 , NBRLIG, NBRCOL=1;

    public UneFenetre() {
        int n=10;

        NBRLIG = n;
        setVisible(true);
        setSize(LARG, HAUT);
        Container leConteneur = getContentPane(); 
        leConteneur.setLayout (new GridLayout(NBRLIG, NBRCOL)); 
        mobiles = new ArrayList<>();
        threads = new ArrayList<>();

        for (int i=0;i<n; i++) {
            UnMobile mobile = new UnMobile(LARG, HAUT/NBRLIG);
            mobiles.add(mobile);
            leConteneur.add(mobile);
            Thread tache = new Thread(mobile);
            threads.add(tache);
        }

        for (Thread tache : threads) 
            tache.start();
    }
}
