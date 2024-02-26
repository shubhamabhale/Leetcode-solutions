class BoundedBlockingQueue {
    ReentrantLock lock;
    Semaphore empty, full;
    Queue<Integer> queue;
    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        lock = new ReentrantLock();
        empty = new Semaphore(capacity);
        full = new Semaphore(0);
    }
    
    public void enqueue(int element) throws InterruptedException {
        
        empty.acquire();
        lock.lock();
        queue.add(element);
        lock.unlock();
        full.release();
    }
    
    public int dequeue() throws InterruptedException {
        int ans=0;
        full.acquire();
        lock.lock();
        if(!queue.isEmpty())
            ans = queue.poll();

        lock.unlock();
        empty.release();
        return ans;
    }
    
    public int size() {
        return queue.size();
    }
}