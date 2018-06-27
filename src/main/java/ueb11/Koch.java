package ueb11;

public class Koch implements Runnable{
    private String name;
    private int anzSpeisen;
    private DurchreicheImpl <Speise> durchreiche;

    Koch (String name, int anzSpeisen, DurchreicheImpl<Speise> durchreiche){
        this.name = name;
        this.anzSpeisen = anzSpeisen;
        this.durchreiche = durchreiche;;
    }

    @Override
    public void run() {
        for (int i = 0; i < anzSpeisen; i++) {
            Speise speise = new Speise("Essen" + i);
            durchreiche.put(speise);
            System.out.println(name + " hat " + speise.toString() + " in die Durchreiche gestellt.");
        }
    }
}
