/**
 * Created by Lucian on 24.11.2015.
 */
public class Main {

    public static final String FILE_GRAMATICA = "input/gramatica.txt";

    public static void main(String[] args) {

        Loader loader = new Loader(FILE_GRAMATICA);

        AnalizorSintactic analizorSintactic = new AnalizorSintactic(loader);
        try {
            System.out.println(analizorSintactic.verificaSecventa());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println(analizorSintactic.getListaDescendenti());
        }

    }
}
