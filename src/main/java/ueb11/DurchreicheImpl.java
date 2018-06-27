package ueb11;
import java.util.LinkedList;
import java.util.Queue;

public class DurchreicheImpl <T> implements Durchreiche {
    Queue<T> speisenListe = new LinkedList<>();
    int anz = speisenListe.size();
    int k;

    DurchreicheImpl(int k) {
        this.k = k;
    }

    @Override
    public T get() {
        synchronized (this) {
            while (anz < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notifyAll();
            return speisenListe.remove();
        }
    }

    @Override
    public void put(Object o) {
        synchronized (o) {
            while (anz > k) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            anz++;
            speisenListe.add((T) o);
            notifyAll();
        }
    }
}
