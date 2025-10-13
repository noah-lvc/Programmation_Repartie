public final class semaphoreGeneral extends semaphore {
    private final int maxValeur;

    public semaphoreGeneral(int maxValeur) {
        super(maxValeur); 
        this.maxValeur = maxValeur;
    }

    @Override
    public synchronized void syncSignal() {
        if (valeur < maxValeur) {
            valeur++;
            notifyAll();
        }
    }
}
