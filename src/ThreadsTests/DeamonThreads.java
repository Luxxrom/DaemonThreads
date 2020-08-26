package ThreadsTests;

public class DeamonThreads {
    public static void main(String[] args) {
        new ThreadTest(16);
        new DaemonDemo();
    }
}

class DaemonDemo extends Thread {
    public DaemonDemo() {
        super("Daemon demo thread");
        setDaemon(true);
        start();
    }

    public void run() {
        Thread threads[] = new Thread[10];
        while (true) {
            int count = ThreadTest.GROUP.activeCount();
            if (threads.length < count) threads = new Thread[count + 10];
            count = ThreadTest.GROUP.enumerate(threads);

            for (int i = 0; i < count; i++) {
                System.out.print(threads[i].getName() + ", ");
            }
            System.out.println("Line");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }
    }
}
