public final class semaphoreGeneral extends semaphore {
    private final int maxValeur;

    // un seul paramètre
    public semaphoreGeneral(int maxValeur) {
        super(maxValeur);  // on démarre plein
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
