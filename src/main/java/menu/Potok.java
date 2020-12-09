package menu;

public class Potok implements Runnable {
    Thread potok;
    Monitor<Integer> monitor;

    Potok(Monitor<Integer> monitore) {
        potok = new Thread(this, "Pot");
        this.monitor = monitore;
        potok.start();
    }

    @Override
    public void run() {
        while (monitor.getValue() == 1) {
            System.out.println("processed...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
