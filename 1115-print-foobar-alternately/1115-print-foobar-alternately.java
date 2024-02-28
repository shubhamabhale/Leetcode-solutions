class FooBar {
    private int n;
   
    private Semaphore fooS, barS;
    
    public FooBar(int n) {
        this.n = n;
        fooS = new Semaphore(1);
        barS = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            fooS.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            barS.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            barS.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            fooS.release();
        }
    }
}