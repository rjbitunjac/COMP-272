public class BinaryTree<E> {

    int size;
    Node2<E> root;

    public BinaryTree () {
        size =0;
        root=null;
    }


    public BinaryTree(E val) {
        root = new Node2(val);
        // root node only
        size=1;

    }
    public boolean isEmpty() {
        return size==0;
    }


    public Node2<E> addLeft(Node2<E> node, E val) {
        Node2<E> n = new Node2(val);
        node.addLeft(n);
        size++;
        return n;
    }

    public Node2<E> addRight(Node2<E> node, E val) {

        Node2<E> n = new Node2(val);
        node.addRight(n);
        size++;
        return n ;
    }


    public void preOrder(Node2<E> n) {

        if (n==null) return;
        System.out.println(n.getInfo());
        preOrder(n.getLeft());
        preOrder(n.getRight());

    }

    public void inOrder(Node2<E> n) {

        if (n==null) return;
        inOrder(n.getLeft());
        System.out.println(n.getInfo());
        inOrder(n.getRight());

    }

    public void postOrder(Node2<E> n) {

        if (n==null) return;
        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.println(n.getInfo());

    }

    public boolean hasLeft(Node2<E> n){
        return (n.getLeft() != null);
    }

    public boolean hasRight(Node2<E> n){
        return (n.getRight() != null);
    }

    public static void main(String[] args){

        // BinaryTree<String> bt = new BinaryTree<>("cat");
        // bt.addLeft(bt.root,"dog");
        //
        /*
        BinaryTree<String> bt = new BinaryTree<>("-");
        Node2<String> n1 =bt.addLeft(bt.root,"*");
        Node2<String> n2 = bt.addRight(bt.root,"/");
        bt.addLeft(n1,"x");
        bt.addRight(n1,"y");
        bt.addLeft(n2,"y");
        bt.addRight(n2,"z");
        bt.postOrder(bt.root);
         */
    }

}