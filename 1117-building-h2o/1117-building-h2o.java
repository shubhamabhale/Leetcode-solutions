class H2O {
    private Semaphore oxygen;
    private Semaphore hydrogen;
    public H2O() {
        oxygen = new Semaphore(0);
        hydrogen = new Semaphore(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		oxygen.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hydrogen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        hydrogen.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        oxygen.release(2);
    }
}