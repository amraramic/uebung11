package ueb11;

public class Kellner implements Runnable {
    private String name;
    private int anzBedinungen;
    private DurchreicheImpl <Speise> durchreiche;

    Kellner(String name, int anzBedinungen, DurchreicheImpl <Speise> durchreiche){
        this.name = name;
        this.anzBedinungen = anzBedinungen;
        this.durchreiche=durchreiche;
    }

    @Override
    public void run() {
        for (int i = 0; i < anzBedinungen ; i++) {
            Speise speise = new Speise("Essen " + i);
            durchreiche.get();
            System.out.println(name + " hat " + speise.toString() + " aus der Durchreiche genommen.");
        }
    }
}
