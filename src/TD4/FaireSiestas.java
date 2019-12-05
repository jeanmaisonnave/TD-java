package TD4;

public class FaireSiestas {
    public static void main(String[] args) throws Exception {
        Room room = new Room();
        System.out.println("Je travaille ... oups 1 room pour tout le monde!");
        Siesta[] siestas = new Siesta[args.length];
        for (int i = 0; i < args.length; i++) {
            System.out.println("Creating and starting siesta " + i);
            siestas[i] = new Siesta(Integer.parseInt(args[i]), "ID" + i, room);
            siestas[i].start();
        }
        System.out.println("Je suis fatigué, je dors un peu");
        Thread.sleep(3000);
        System.out.println("Ca y est ! c'est fini !");
        for (int i = 0; i < args.length; i++) {
            siestas[i].interrupt();
        }
    }
}
