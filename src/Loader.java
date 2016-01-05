import java.io.*;
import java.util.*;

/**
 * Created with love by Lucian on 24.11.2015.
 */
class Loader {

    private String secventa;
    private final Gramatica gramatica;

    public String getSecventa() {
        return secventa;
    }

    public ArrayList<RegulaProductie> getGramatica() {
        return gramatica.getGramatica();
    }

    public Loader(@SuppressWarnings("SameParameterValue") String FILE_GRAMATICA) {
        gramatica = new Gramatica();
        readFromFile(FILE_GRAMATICA);
        readSecventa();
    }

    private void readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                parseLine(line);
            }
            bufferedReader.close();
            System.out.println("Grammar successfully read from file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLine(String line) {
        String[] words = line.split(" ");
        if (!words[0].equals("") && !words[1].equals("")) {
            gramatica.addRegulaProductie(new RegulaProductie(words[0], words[1]));
        }
    }

    private void readSecventa() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Dati secventa: ");
        try {
            secventa = bufferedReader.readLine();
            while (secventa.equals("")) {
                System.err.println("Secventa vida nu este acceptata");
                System.out.print("Dati o noua secventa: ");
                secventa = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
