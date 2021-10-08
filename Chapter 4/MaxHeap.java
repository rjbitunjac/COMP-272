import java.util.*;

public class MaxHeap<E extends Comparable<E>> extends ArrayList<E>   {
    // construct an empty Heap using ArrayList
    // with root at index 0.
    // don't use binary tree for implementing the heap.
    E root;

    public MaxHeap(){
        this.root = null;
    }
    // returns max value
    public E findMax() {
        if(this.size() == 0){
            System.out.println("Heap is empty");
        }
        return this.root;
    }

    // adds a new value to the heap at the end of the Heap and 
    // adjusts values up to the root to ensure Max heap property is satisfied.
    // parent of node at i is given by the formula (i-1)/2
    // throw appropriate exception
    public void addHeap(E val) {
        this.add(val);

        if(this.size() == 1){
            this.root = this.get(0);
        }

        int i = this.indexOf(val);
        E temp;

        while(val.compareTo(this.get((i-1)/2)) > 0){
            temp = this.get((i-1)/2);
            this.set((i-1)/2 , val);
            this.set(i, temp);
            i = this.indexOf(val);
            root = this.get(0);
        }
    }  // addHeap has a runtime complexity of O(log n) because the while loop doesn't quite iterate n times
       // (the most it can iterate is the number depth of the heap, which is at most log n).

    //returns the max value at the root of the heap by swapping the last value 
    // and percolating the value down from the root to preserve max heap property
    // children of node at i are given by the formula 2i+1,2i+2, to not exceed the
    // bounds of the Heap index, namely, 0 ... size()-1.
    // throw appropriate exception
    public E removeHeap() {
        E originalRoot = this.root; // removed root, being returned at the end
        E oldLast = this.get(size() - 1); // takes the last node and stores it in oldLast
        E temp;
        this.set(0, oldLast); // puts the last node at the front
        this.remove((this.size()-1)); // removes the last node since it now sits at the front
        int i = 0;
        while(oldLast.compareTo(this.get((2*i+1))) < 0 || oldLast.compareTo(this.get((2*i+2))) < 0){
            if(oldLast.compareTo(this.get((2*i+1))) < 0){
                temp = this.get(2*i+1);
                this.set((2*i+1), oldLast);
                this.set(i, temp);
                i = this.indexOf(oldLast);
            }else{
                if(oldLast.compareTo(this.get(2*i+2)) < 0){
                    temp = this.get(2*i+2);
                    this.set(2*i+2, oldLast);
                    this.set(i, temp);
                    i = this.indexOf(oldLast);
                }
            }
            if(2*i+1 >= this.size() || 2*i+2 >= this.size()){
                return originalRoot;
            }
        }
        this.root = this.get(0);

        return originalRoot;
    }

    // takes a list of items E and builds the heap and then prints 
    // decreasing values of E with calls to removeHeap().  
    public void heapSort(List<E> list){
        this.buildHeap(list);
        for(int i = 0; i < this.size(); i++){
            System.out.println(this.removeHeap());
        }
    }

    // merges the other maxheap with this maxheap to produce a new maxHeap.  
    public void heapMerge(MaxHeap<E> other){
        for(int i = 0; i < other.size(); i++){
            this.addHeap(other.get(i));
        }
        // heapMerge has a runtime complexity of O(n log n) because
        // addHeap has O(log n) time complexity, and the for loop runs n times
    }

    //takes a list of items E and builds the heap by calls to addHeap(..)
    public void buildHeap(List<E> list) {
        for(int i = 0; i < list.size(); i++){
            this.addHeap(list.get(i));
        }
    } // buildHeap has a runtime complexity of O(n log n)

    public static void main(String[] args) {
        MaxHeap<Integer> test = new MaxHeap<>();
        test.addHeap(45);
        test.addHeap(35);
        test.addHeap(23);
        test.addHeap(27);
        test.addHeap(21);
        test.addHeap(22);
        test.addHeap(4);
        test.addHeap(19);

        test.removeHeap();

        for(int i = 0; i < test.size(); i++){
            System.out.println(test.get(i));
        }
    }
}