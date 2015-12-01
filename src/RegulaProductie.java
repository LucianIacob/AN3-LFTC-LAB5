/**
 * Created by Lucian on 24.11.2015.
 */
public class RegulaProductie {

    private String leftHand;
    private String rightHand;

    public RegulaProductie(String leftHand, String rightHand) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    public String getLeftHand() {
        return leftHand;
    }

    public String getRightHand() {
        return rightHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegulaProductie that = (RegulaProductie) o;

        if (leftHand != null ? !leftHand.equals(that.leftHand) : that.leftHand != null) return false;
        return !(rightHand != null ? !rightHand.equals(that.rightHand) : that.rightHand != null);

    }

    @Override
    public int hashCode() {
        int result = leftHand != null ? leftHand.hashCode() : 0;
        result = 31 * result + (rightHand != null ? rightHand.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegulaProductie{" +
                "leftHand='" + leftHand + '\'' +
                ", rightHand='" + rightHand + '\'' +
                '}';
    }
}
