import javax.swing.*;
import java.awt.*;

public class UnMobile extends JPanel implements Runnable {
    int saLargeur, saHauteur, sonDebutDessin;
    final int sonPas= 10, sonTemps= 50, sonCote= 40;

    public UnMobile(int telleLargeur, int telleHauteur){
        super();
            saLargeur= telleLargeur;saHauteur= telleHauteur;
            setSize( telleLargeur, telleHauteur );
        }//UnMobile

        public void run(){
        for(sonDebutDessin= 0;sonDebutDessin < saLargeur - sonPas; sonDebutDessin += sonPas){
            repaint();
                try{
                    Thread.sleep((int)(Math.random()*500)); //Cooldown aléatoire
                }//try
                catch(InterruptedException telleExcp)
                {telleExcp.printStackTrace();}//catch
            }//for

        for(sonDebutDessin= saLargeur - sonPas;sonDebutDessin > 0; sonDebutDessin -= sonPas){
            repaint();
                try{
                    Thread.sleep((int)(Math.random()*500)); //Cooldown aléatoire 
                }//try
                catch(InterruptedException telleExcp)
                {telleExcp.printStackTrace();}//catch
            }//for
        }//run()



        public void paintComponent( Graphics telContexteGraphique)
        { super.paintComponent( telContexteGraphique );
            telContexteGraphique.fillRect( sonDebutDessin, saHauteur/2, sonCote, sonCote);
        }//paintComponent()
    }//classe UnMobile