package ThreadsTests;

public class ThreadTest implements Runnable {

    public final static ThreadGroup GROUP = new ThreadGroup("Deamon demo");

    private int start;

    public ThreadTest(int s) {
        start = (s % 2 == 0) ? s : s + 1;
        new Thread(GROUP, this, "Thread " + start).start();
    }

    public void run() {
        for (int i = start; i > 0; i--) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
            if (start > 2 && i == start / 2) {
                new ThreadTest(i);
            }
        }
    }
}



