public class Node2 <E>{

    Node2<E> left;
    Node2<E> right;
    Node2<E> parent;
    E  info;

    public Node2(Node2<E> le, Node2<E> ri, Node2<E> pa){
        left=le;
        right=ri;
        parent=pa;
    }

    public Node2(E val){
        left=null;
        right=null;
        parent=null;
        info=val;
    }

    public Node2(){
        left=null;
        right=null;
        parent=null;
        info=null;
    }

    public void addLeft(Node2<E> le) {
        left=le;
        le.addParent(this);
    }

    public void addRight(Node2<E> ri) {
        right=ri;
        ri.addParent(this);
    }

    public void addParent(Node2<E> pa){
        parent=pa;
    }

    public void setInfo(E val){
        info=val;
    }

    public E getInfo() {
        return info;
    }

    public Node2<E> getLeft(){
        return left;
    }
    public Node2<E> getRight(){
        return right;
    }
}