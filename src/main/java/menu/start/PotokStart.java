package menu.start;

import menu.Monitor;

public class PotokStart implements Runnable {
    Thread potok;
    Monitor<Integer> monitor;

    public PotokStart(Monitor<Integer> monitor) {
        potok = new Thread(this, "PotStart");
        this.monitor = monitor;
        potok.start();
    }

    @Override
    public void run() {
        while (monitor.getValue() == 1) {
            System.out.println("processed");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
