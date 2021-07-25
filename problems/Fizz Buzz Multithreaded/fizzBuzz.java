class FizzBuzz {
    private int n;
    private int counter;

    public FizzBuzz(int n) {
        this.n = n;
        this.counter = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (n >= counter) {
                if (0 == counter % 3 && 0 != counter % 5) {
                    ++counter;
                    printFizz.run();
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (n >= counter) {
                if (0 == counter % 5 && 0 != counter % 3) {
                    printBuzz.run();
                    ++counter;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (n >= counter) {
                if (0 == counter % 15) {
                    printFizzBuzz.run();
                    ++counter;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (n >= counter) {
                if (0 == counter % 3 || 0 == counter % 5) {
                    wait();
                } else {
                    printNumber.accept(counter);
                    ++counter;
                    notifyAll();
                }
            }
        }
    }
}
