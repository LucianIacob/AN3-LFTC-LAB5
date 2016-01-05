import java.util.ArrayList;
import java.util.List;

/**
 * Created with love by Lucian and @Pi on 04.12.2015.
 */
public class Node<T> {
    private final List<Node<T>> children = new ArrayList<>();
    private Node<T> parent = null;
    private T data = null;

    public Node<T> getParent() {
        return parent;
    }

    public Node(T data) {
        this.data = data;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void addChild(Node<T> child) {
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

}