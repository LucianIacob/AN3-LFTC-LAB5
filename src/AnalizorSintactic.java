import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;

/**
 * Created by Lucian on 24.11.2015.
 */
public class AnalizorSintactic {

    public ArrayList<Descendent> getListaDescendenti() {
        return listaDescendenti;
    }

    private ArrayList<Descendent> listaDescendenti;
    private Loader loader;
    private ArrayList<RegulaProductie> gramatica;
    private static final String EBSILON = "Ebsilon";
    private static final String STARE_NORMALA = "q";
    private static final String STARE_REVENIRE = "r";
    private static final String STARE_TERMINARE = "t";

    public AnalizorSintactic(Loader loader) {
        this.loader = loader;
        gramatica = loader.getGramatica();
        listaDescendenti = new ArrayList<>();
    }

    public boolean treeSearch(Node<Descendent> currentNode) {

        //verificam daca incepe cu S atunci parcurgem regulile de proiductie din gramatica
        //altfel verificam daca primul caracter de pe banda de intrare e ok cu secventa
        //daca e ok generam primul fiu si mergem pe el
        //altfel revenim la urmatorul fiu al parintelui, in cazul in care nu mai sunt fi la urmatorul fiu al bunicului s.a.m.d.
        //daca e epsilon verificam daca contorul secventei e egal cu n+1 lungimea secventei atuncie ok altfel nu e ok

        Descendent currentData = currentNode.getData();
        if (currentData.getPozitiaInSecventa() == loader.getSecventa().length()) {
            if (currentData.getBandaDeIntrare().isEmpty()) {
                return true;
            } else {
                if (!currentNode.getData().getStivaDeLucru().equals(EBSILON)) {
                    currentNode.getParent().getData().setStareaAutomatului(STARE_REVENIRE);
                    listaDescendenti.add(new Descendent(STARE_REVENIRE,
                            currentData.getPozitiaInSecventa(),
                            currentData.getStivaDeLucru(),
                            currentData.getBandaDeIntrare()));
                    return treeSearch(currentNode.getParent());
                } else {
                    return false;
                }
            }
        } else if (currentData.getBandaDeIntrare().substring(0, 1).equals("S")) {

            if (currentNode.getChildren().size() < gramatica.size()) {
                Node<Descendent> descendentNode = new Node<>(new Descendent(STARE_NORMALA,
                        currentData.getPozitiaInSecventa(),
                        currentData.getStivaDeLucru() + gramatica.get(currentNode.getChildren().size()).getLeftHand(),
                        gramatica.get(currentNode.getChildren().size()).getRightHand() + currentData.getBandaDeIntrare().substring(1)));
                listaDescendenti.add(new Descendent(descendentNode.getData().getStareaAutomatului(),
                        descendentNode.getData().getPozitiaInSecventa(),
                        descendentNode.getData().getStivaDeLucru(),
                        descendentNode.getData().getBandaDeIntrare()));
                descendentNode.setParent(currentNode);
                currentNode.addChild(descendentNode);
                return treeSearch(descendentNode);
            } else {
                if (!currentNode.getData().getStivaDeLucru().equals(EBSILON)) {
                    return treeSearch(currentNode.getParent());
                } else {
                    return false;
                }
            }
        } else {
            if (currentData.getStareaAutomatului().equals(STARE_REVENIRE)) {
                currentNode.getParent().getData().setStareaAutomatului(STARE_REVENIRE);
                return treeSearch(currentNode.getParent());

            } else {
                if (loader.getSecventa().substring(currentData.getPozitiaInSecventa(), currentData.getPozitiaInSecventa() + 1).
                        equals(currentData.getBandaDeIntrare().substring(0, 1))) {
                    Node<Descendent> descendentNode = new Node<>(new Descendent(STARE_NORMALA,
                            currentData.getPozitiaInSecventa() + 1,
                            currentData.getStivaDeLucru() + currentData.getBandaDeIntrare().substring(0, 1),
                            currentData.getBandaDeIntrare().substring(1)));

                    listaDescendenti.add(new Descendent(descendentNode.getData().getStareaAutomatului(),
                            descendentNode.getData().getPozitiaInSecventa(),
                            descendentNode.getData().getStivaDeLucru(),
                            descendentNode.getData().getBandaDeIntrare()));
                    descendentNode.setParent(currentNode);
                    currentNode.addChild(descendentNode);
                    return treeSearch(descendentNode);
                } else {
                    listaDescendenti.add(new Descendent(STARE_REVENIRE,
                            currentData.getPozitiaInSecventa(),
                            currentData.getStivaDeLucru(),
                            currentData.getBandaDeIntrare()));
                    currentNode.getParent().getData().setStareaAutomatului(STARE_REVENIRE);
                    return treeSearch(currentNode.getParent());
                }
            }
        }
    }


    public boolean verificaSecventa() {
        Descendent firstDescendent = new Descendent(STARE_NORMALA, 0, EBSILON, "S");
        Node<Descendent> root = new Node<>(firstDescendent);
        listaDescendenti.add(firstDescendent);
        return treeSearch(root);
    }
}
