/**
 * 
 */
import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Affichage extends Thread{
	String texte; 
	static semaphoreBinaire semaphore = new semaphoreBinaire(1);

	public Affichage (String txt){texte=txt;}
	
	public void run(){
		//debut section critique
		semaphore.syncWait();
		for (int i=0; i<texte.length(); i++){
		    System.out.print(texte.charAt(i)); //out est la resource critique
		    try {sleep(100);} catch(InterruptedException e){};
		}
		semaphore.syncSignal();
		//fin section critique
	}
}
