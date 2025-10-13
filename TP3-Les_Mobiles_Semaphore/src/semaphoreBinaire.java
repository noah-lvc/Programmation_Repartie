
public final class semaphoreBinaire extends semaphore {
public semaphoreBinaire(int valeurInitiale){
	super((valeurInitiale != 0) ? 1:0);
	//System.out.print(valeurInitiale);
}
	
public final synchronized void syncSignal(){
	super.syncSignal();
	//System.out.print(valeur);
	if (valeur>1) valeur = 1;
}
}


public final class semaphoreGeneral extends semaphore {
public semaphoreGeneral(int valeurInitiale, int n){
	super((valeurInitiale != 0) ? 1:n);
	//System.out.print(valeurInitiale);
}
	
public final synchronized void syncSignal(){
	super.syncSignal();
	//System.out.print(valeur);
	if (valeur>1) valeur = 1;
}
}

