public class Demo {
    private static int count = 0;

    public static synchronized void inccount() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                inccount();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                inccount();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Value: " + count);
    }
}