
/**
 * Created with love by Lucian and @Pi on 24.11.2015.
 */
class Main {

    private static final String FILE_GRAMATICA = "input/gramatica.txt";

    public static void main(String[] args) {

        Loader loader = new Loader(FILE_GRAMATICA);
        AnalizorSintactic analizorSintactic = new AnalizorSintactic(loader);

        try {
            if (analizorSintactic.secventaIsValida()) {
                //System.out.println(analizorSintactic.getListaDescendenti());
                System.out.println();
                System.out.println("Secventa este acceptata.");
                analizorSintactic.printArboreleDeAnaliza();
            } else {
                System.out.println();
                System.out.println("Secventa nu este acceptata.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
