class Foo {
    private AtomicInteger jobCounter = new AtomicInteger(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        jobCounter.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (1 != jobCounter.get()) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        jobCounter.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (2 != jobCounter.get()) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
