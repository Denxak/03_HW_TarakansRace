package ait.tarakansrace.runner;

import java.util.Random;

import static ait.tarakansrace.TarakansRaceAppl.*;

public class Tarakan implements Runnable {
    private int id;
    private int distance;

    public Tarakan(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    @Override
    public void run() {
        System.out.println("Tarakan #" + id + " started to run");
        for (int i = 0; i < distance; i++) {
            int sleepTime = new Random().nextInt(MIN_SLEEP, MAX_SLEEP);
            System.out.println("Tarakan #" + id + ", Distance " + i + " of " + distance + ", Sleep:" + sleepTime);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Tarakan #" + id + " ran to the finish line");
        setWinner(id);
    }
}
