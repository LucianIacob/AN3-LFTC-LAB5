import java.util.ArrayList;

/**
 * Created by Lucian on 24.11.2015.
 */
public class Gramatica {

    private ArrayList<RegulaProductie> gramatica;

    public Gramatica() {
        gramatica = new ArrayList<>();
    }

    public void addRegulaProductie(RegulaProductie regulaProductie) {
        gramatica.add(regulaProductie);
    }

    public ArrayList<RegulaProductie> getGramatica() {
        return gramatica;
    }
}
