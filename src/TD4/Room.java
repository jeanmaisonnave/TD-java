package TD4;

public class Room {
    private boolean busy = false;

    public synchronized void checkIn() throws InterruptedException {
        boolean firstTime = true;
        while (busy) {
            if (!firstTime)
                System.out.println("Réveillé pour rien");
            wait();
            firstTime = false;
        }
        busy = true;
    }

    public synchronized void checkOut() {
        busy = false;
        notify();
    }
}
