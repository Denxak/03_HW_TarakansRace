package ait.tarakansrace;

import ait.tarakansrace.runner.Tarakan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class TarakansRaceAppl {
    public static final int MIN_SLEEP = 2;
    public static final int MAX_SLEEP = 6;
    private static int winnerId = -1;

    public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of tarakans: ");
        int numOfTar = Integer.parseInt(br.readLine());
        System.out.print("Enter race distance (iterations): ");
        int distance = Integer.parseInt(br.readLine());
        System.out.println("Number of tarakans: " + numOfTar);
        System.out.println("Race distance: " + distance);
        System.out.println("The race has started!");

        Thread[] threads = IntStream.range(0, numOfTar)
                .mapToObj(i -> new Thread(new Tarakan(i, distance)))
                .peek(Thread::start)
                .toArray(Thread[]::new);
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(winnerId != -1
                ? "Congratulations to tarakan #" + winnerId + " (winner)!"
                : "No winner, something went wrong!");
        System.out.println("The race has finished!");
    }

    public static void setWinner(int id) {
        if (winnerId == -1) {
            winnerId = id;
        }
    }
}
