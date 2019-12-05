package TD4;

public class Siesta extends Thread {
    private String id;
    private Room room;
    private int tempsSiesta;

    public Siesta(int temps, String ident, Room theRoom) {
        super();
        tempsSiesta = temps;
        id = ident;
        room = theRoom;
    }

    public Siesta(int temps) {
        tempsSiesta = temps;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Siesta " + id + " veut utiliser la room");
                room.checkIn();
                System.out.println("La room est à " + id + "sleeping : " + tempsSiesta);
                sleep(tempsSiesta);
                System.out.println("Siesta " + id + "checking out");
                room.checkOut();
            } catch (InterruptedException e) {
                System.out.println("Thread de Siesta " + id + "terminee");
                break;
            }
        }
    }
}