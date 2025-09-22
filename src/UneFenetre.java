import javax.swing.*;
import java.awt.*;

public class UneFenetre extends JFrame {
    private UnMobile sonMobile;
    private final int LARG=400, HAUT=250;

    public UneFenetre() {
        setVisible(true);
        setSize(LARG, HAUT);
        Container container = getContentPane();
        sonMobile = new UnMobile(LARG, HAUT);
        container.add(sonMobile);
        Thread laTache = new Thread(sonMobile);
        laTache.start();
    }
}
