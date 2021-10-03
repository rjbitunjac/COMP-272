public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public BinarySearchTree() {
        super();
    }
    public BinarySearchTree(E val) {
        super(val);
    }

    // returns true if BST has val else false.
    public boolean contains (E val) {

        boolean result = false;

        if(root == null){
            return false;
        }else {

            Node2<E> current = root;

            while(current != null){

                if(val.compareTo(current.getInfo()) == 0){
                    return true;

                }else if(val.compareTo(current.getInfo()) < 0){
                    current = current.getLeft();

                }else{
                    current = current.getRight();
                }
            }
        }
        return result;

    }
    // inserts val at the right place satisfying search tree properties, should handle if the tree is empty
    // if value is already there then don’t insert it again
    public void insert(E val) {

        Node2<E> current = root;
        Node2<E> parent = null;

        if (root == null){
            root = new Node2(val);
        }else {

            while (current != null) {
                parent = current;

                if (val.compareTo(current.getInfo()) < 0) {
                    current = current.getLeft();

                } else if(val.compareTo(current.getInfo()) > 0){
                    current = current.getRight();

                }else{
                    break;
                }
            }

            if (val.compareTo(parent.getInfo()) < 0) {
                parent.left = new Node2(val);

            } else if(val.compareTo(parent.getInfo()) > 0){
                parent.right = new Node2(val);

            }else{
                System.out.println("Element is already in the BinarySearchTree");
            }
        }
    }

    // returns the minimum value stored in the tree
    public E findMin() {

        if(super.root == null){

            System.out.println("Error, BinarySearchTree contains no values");
            return null;
        }

        Node2<E> current = super.root;
        E result;

        while(super.hasLeft(current)){
            current = current.getLeft();
        }

        result = current.getInfo();

        return result;
    }

    // returns the maximum value stored in the tree
    public E findMax() {

        if(super.root == null){

            System.out.println("Error, BinarySearchTree contains no values");
            return null;
        }

        Node2<E> current = super.root;
        E result;

        while(super.hasRight(current)){
            current = current.getRight();
        }

        result = current.getInfo();
        
        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bt= new BinarySearchTree<>();
        bt.insert(5);
        bt.insert(10);
        bt.insert(5);
        bt.insert(20);
        bt.insert(8);
        bt.insert(4);
        bt.postOrder(bt.root);
    }
}