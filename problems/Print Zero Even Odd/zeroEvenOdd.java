class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSemaphore = new Semaphore(1);
    private Semaphore evenSemaphore = new Semaphore(0);
    private Semaphore oddSemaphore = new Semaphore(2);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int idx = 0; n > idx; ++idx) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            evenSemaphore.release();
            oddSemaphore.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int idx = 2; n >= idx; idx += 2) {
            evenSemaphore.acquire(3);
            printNumber.accept(idx);
            zeroSemaphore.release();
            oddSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int idx = 1; n >= idx; idx += 2) {
            oddSemaphore.acquire(3);
            printNumber.accept(idx);
            zeroSemaphore.release();
            evenSemaphore.release();
        }
    }
}
