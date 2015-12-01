/**
 * Created by Lucian on 24.11.2015.
 */
public class Main {

    public static final String FILE_GRAMATICA = "C:\\Users\\Lucian\\Google Drive\\Computer Science\\Lab6_LFTC\\input\\gramatica.txt";

    public static void main(String[] args) {

        Loader loader = new Loader(FILE_GRAMATICA);
        AnalizorSintactic analizorSintactic = new AnalizorSintactic(loader);

        if (analizorSintactic.verificaSecventa())
            System.out.println("Secventa acceptata");
    }
}
