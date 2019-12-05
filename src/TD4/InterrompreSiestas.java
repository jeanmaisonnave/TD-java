package TD4;

public class InterrompreSiestas {
    public static void main(String[] args) throws Exception {
        Siesta siesta = new Siesta(1000);
        siesta.start();
        System.out.println("Je travaille entre temps");
        for (int i = 0; i < 8; i++) {
            Thread.sleep(500);
            siesta.interrupt();
            System.out.println("Je viens de réveiller siesta et je travaille encore " + i);
        }
        System.out.println("Travail terminé");
    }
}
