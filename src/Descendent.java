/**
 * Created with love by Lucian and @Pi on 24.11.2015.
 */
class Descendent {

    private String stareaAutomatului;
    private final int pozitiaInSecventa;
    private final String stivaDeLucru;
    private final String bandaDeIntrare;

    public Descendent(String stareaAutomatului, int pozitiaInSecventa, String stivaDeLucru, String bandaDeIntrare) {
        this.stareaAutomatului = stareaAutomatului;
        this.pozitiaInSecventa = pozitiaInSecventa;
        this.stivaDeLucru = stivaDeLucru;
        this.bandaDeIntrare = bandaDeIntrare;
    }

    public String getStareaAutomatului() {
        return stareaAutomatului;
    }

    @Override
    public String toString() {
        return "Descendent{" +
                "stareaAutomatului='" + stareaAutomatului + '\'' +
                ", pozitiaInSecventa='" + pozitiaInSecventa + '\'' +
                ", stivaDeLucru='" + stivaDeLucru + '\'' +
                ", bandaDeIntrare='" + bandaDeIntrare + '\'' +
                '}' + "\n";
    }

    public void setStareaAutomatului(@SuppressWarnings("SameParameterValue") String stareaAutomatului) {
        this.stareaAutomatului = stareaAutomatului;
    }

    public int getPozitiaInSecventa() {
        return pozitiaInSecventa;
    }

    public String getStivaDeLucru() {
        return stivaDeLucru;
    }

    public String getBandaDeIntrare() {
        return bandaDeIntrare;
    }

}
