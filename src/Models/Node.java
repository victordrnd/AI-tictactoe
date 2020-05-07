package Models;
import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> children = new ArrayList<Node>();
    private Node parent = null;
    private float grade = 0;
    private Board board = null;

    public Node(Board board, float grade) {
        this.board = board;
        this.grade = grade;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setParent(Node parent) {
        parent.addChild(this);
        this.parent = parent;
    }

    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }

    public boolean isRoot(){
        return parent == null;
    }

    public boolean hasChildren(){
        return this.children.size() == 0;
    }
}