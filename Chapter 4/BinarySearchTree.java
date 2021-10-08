public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    BinaryTree<E> binTree = null;

    public BinarySearchTree() {
        super();
    }
    public BinarySearchTree(E val) {
        super(val);
    }

    // returns true if BST has val else false.
    public boolean contains (E val) {

        return false;

    }
    // inserts val at the right place satisfying search tree properties, should handle if the tree is empty
    // if value is already there then don’t insert it again
    public void insert(E val) {

        if(super.root == null){
            binTree = new BinaryTree(val);
        }else{
            Node2<E> current = binTree.root;
            Node2<E> previous = null;
            boolean valPresent = false;

            while(current != null){

                previous = current;
                if(val.compareTo(current.getInfo()) < 0){
                    current = current.getLeft();
                }else if(val.compareTo(current.getInfo()) > 0){
                    current = current.getRight();
                }else{
                    valPresent = true;
                    System.out.println("Value is already in tree");
                    break;
                }

                if(val.compareTo(previous.getInfo()) < 0){
                    binTree.addLeft(previous, val);
                }else if(val.compareTo(previous.getInfo()) > 0){
                    binTree.addRight(previous, val);
                }else{
                    break;
                }
            }
        }
    }

    // returns the minimum value stored in the tree
    public E findMin() {
        if(this.binTree == null){
            System.out.println("Error, BinarySearchTree contains no values");
            return null;
        }
        Node2<E> current = this.binTree.root;
        E result;
        while(binTree.hasLeft(current)){
            current = current.getLeft();
        }
        result = current.getInfo();
        return result;
    }

    // returns the maximum value stored in the tree
    public E findMax() {
        if(this.binTree == null){
            System.out.println("Error, BinarySearchTree contains no values");
            return null;
        }
        Node2<E> current = this.binTree.root;
        E result;
        while(binTree.hasRight(current)){
            current = current.getRight();
        }
        result = current.getInfo();
        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bt= new BinarySearchTree<>();
        bt.insert(5);
        bt.insert(10);
        bt.insert(3);
        bt.insert(20);
        bt.insert(8);
        bt.insert(4);


        //BinaryTree<String> bt = new BinaryTree<>("s");
        //Node2<String> n1 =bt.addLeft(bt.root,"v");
        //Node2<String> n2 = bt.addRight(bt.root,"d");
        //bt.addLeft(n1,"x");
        //bt.addRight(n1,"y");
        //bt.addLeft(n2,"a");
        //bt.addRight(n2,"z");
        //BinarySearchTree BST = new BinarySearchTree(bt);
        //System.out.println(BST.contains("t"));
    }
}