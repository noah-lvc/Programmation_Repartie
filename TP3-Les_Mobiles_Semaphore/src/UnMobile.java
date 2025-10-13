import javax.swing.*;
import java.awt.*;

public class UnMobile extends JPanel implements Runnable {
    int saLargeur, saHauteur, sonDebutDessin;
    final int sonPas= 10, sonTemps= 50, sonCote= 40;
    static semaphoreGeneral semaphore = new semaphoreGeneral(5);

    private boolean dansSemaphore = false;

    public UnMobile(int telleLargeur, int telleHauteur){
        super();
            saLargeur= telleLargeur;saHauteur= telleHauteur;
            setSize( telleLargeur, telleHauteur );
        }//UnMobile

        public void run(){
            for(sonDebutDessin= 0;sonDebutDessin < saLargeur/3 - sonPas; sonDebutDessin += sonPas){
                dansSemaphore = false;
                repaint();
                    try{
                        //Thread.sleep((int)(Math.random()*500)); //Cooldown aléatoire
                        Thread.sleep(100);
                    }//try
                    catch(InterruptedException telleExcp)
                    {telleExcp.printStackTrace();}//catch
                }//for

            for(sonDebutDessin= saLargeur/3;sonDebutDessin < saLargeur*2/3 - sonPas; sonDebutDessin += sonPas){
                semaphore.syncWait();
                dansSemaphore = true;
                repaint();
                    try{
                        //Thread.sleep((int)(Math.random()*500)); //Cooldown aléatoire
                        Thread.sleep(100);
                    }//try
                    catch(InterruptedException telleExcp)
                    {telleExcp.printStackTrace();}//catch
                    dansSemaphore = false;
                    semaphore.syncSignal();
                }//for
            
            for(sonDebutDessin= saLargeur*2/3;sonDebutDessin < saLargeur - sonPas; sonDebutDessin += sonPas){
                dansSemaphore = false;
                repaint();
                    try{
                        //Thread.sleep((int)(Math.random()*500)); //Cooldown aléatoire
                        Thread.sleep(100);
                    }//try
                    catch(InterruptedException telleExcp)
                    {telleExcp.printStackTrace();}//catch
                }//for    




                for(sonDebutDessin= saLargeur - sonPas;sonDebutDessin > saLargeur*2/3; sonDebutDessin -= sonPas){
                    dansSemaphore = false;
                    repaint();
                        try{
                            //Thread.sleep((int)(Math.random()*500)); //Cooldown aléatoire 
                            Thread.sleep(100);
                        }//try
                        catch(InterruptedException telleExcp)
                        {telleExcp.printStackTrace();}//catch
                    }//for

                for(sonDebutDessin= saLargeur*2/3 - sonPas;sonDebutDessin > saLargeur*1/3; sonDebutDessin -= sonPas){
                    semaphore.syncWait();
                    dansSemaphore = true;
                    repaint();
                        try{
                            //Thread.sleep((int)(Math.random()*500)); //Cooldown aléatoire 
                            Thread.sleep(100);
                        }//try
                        catch(InterruptedException telleExcp)
                        {telleExcp.printStackTrace();}//catch
                        dansSemaphore = false;
                        semaphore.syncSignal();
                    }//for

                 for(sonDebutDessin= saLargeur*1/3 - sonPas;sonDebutDessin > 0; sonDebutDessin -= sonPas){
                    dansSemaphore = false;
                      repaint();
                        try{
                            //Thread.sleep((int)(Math.random()*500)); //Cooldown aléatoire 
                            Thread.sleep(100);
                        }//try
                        catch(InterruptedException telleExcp)
                        {telleExcp.printStackTrace();}//catch
                    }//for
                }//run()
        


        public void paintComponent( Graphics telContexteGraphique)
        { super.paintComponent( telContexteGraphique );
            telContexteGraphique.setColor(dansSemaphore ? Color.RED : Color.BLACK);
            telContexteGraphique.fillRect( sonDebutDessin, saHauteur/2, sonCote, sonCote);
        }//paintComponent()
    }//classe UnMobile
