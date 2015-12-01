import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;

/**
 * Created by Lucian on 24.11.2015.
 */
public class AnalizorSintactic {

    private ArrayList<Descendent> listaDescendenti;
    private Loader loader;
    private ArrayList<RegulaProductie> gramatica;
    private static final String EBSILON = "Ebsilon";
    private static final String STARE_NORMALA = "q";
    private static final String STARE_REVENIRE = "r";
    private static final String STARE_TERMINARE = "t";
    int contorSecventa = 0;

    public AnalizorSintactic(Loader loader) {
        this.loader = loader;
        gramatica = loader.getGramatica();
        listaDescendenti = new ArrayList<>();
    }

    public void recursivitate() {
        Descendent descendent = listaDescendenti.get(listaDescendenti.size() - 1);

        System.out.println("intrat" + contorSecventa);
        if (loader.getSecventa().length() > contorSecventa) {
            if (loader.getSecventa().charAt(contorSecventa) == descendent.getBandaDeIntrare().charAt(0)) {
                listaDescendenti.add(
                        new Descendent(
                                STARE_NORMALA,
                                ++contorSecventa,
                                descendent.getStivaDeLucru() + descendent.getBandaDeIntrare().charAt(0),
                                descendent.getBandaDeIntrare().substring(1, descendent.getBandaDeIntrare().length())));
                recursivitate();
            }
        }
    }

    public boolean verificaSecventa() {

        boolean moveForward = true;
        int indexGramatica = 0;
        listaDescendenti.add(new Descendent(STARE_NORMALA, contorSecventa, EBSILON, gramatica.get(0).getLeftHand()));

        for (int contorGramatica = 0; contorGramatica < gramatica.size(); contorGramatica++) {
            listaDescendenti.add(
                    new Descendent(
                            STARE_NORMALA,
                            contorSecventa,
                            gramatica.get(contorGramatica).getLeftHand() + contorGramatica,
                            gramatica.get(contorGramatica).getRightHand()));
            recursivitate();
        }
/**

 listaDescendenti.add(new Descendent(STARE_NORMALA, contorSecventa, gramatica.get(0).getLeftHand() + indexGramatica, gramatica.get(0).getRightHand()));

 while (moveForward && indexGramatica < gramatica.size()) {

 Descendent lastDescendent = listaDescendenti.get(listaDescendenti.size() - 1);

 /**
 * Cazul in care primul caracter din Banda de Intrare coincide cu caracterul cu
 * indexul <<contorSecventa>> din secventa

 if (loader.getSecventa().charAt(contorSecventa - 1) == lastDescendent.getBandaDeIntrare().charAt(0)) {
 Descendent descendent = new Descendent(
 STARE_NORMALA,
 ++contorSecventa,
 lastDescendent.getStivaDeLucru() + lastDescendent.getBandaDeIntrare().charAt(0),
 lastDescendent.getBandaDeIntrare().substring(1, lastDescendent.getBandaDeIntrare().length())
 );
 listaDescendenti.add(descendent);
 }

 /**
 * Cazul in care S<<indexGramatica>> nu este compatibila


 break;
 }

 */
        listaDescendenti.forEach(System.out::println);

        return false;
    }
}
