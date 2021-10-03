import java.util.*;

public class MyLinkedList<E> {
    Node<E> first;
    Node<E> last;
    int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size=0;
    }

    public boolean isEmpty() {
        return (size==0);
    }

    public void addFirst(E info) {
        Node<E> n =new Node<>();
        n.setInfo(info);
        if (isEmpty())
            last=n;
        else {
            n.setNext(first);
            first.setPrev(n);
        }
        first=n;
        size++;
    }

    public E removeFirst() {
        if (!isEmpty()) {
            E val = first.getInfo();
            if (size>1) {
                first.getNext().setPrev(null);
                first=first.getNext();
                size--;
            }
            else if (size==1) {
                first=null;
                last=null;
                size--;
            }
            return val;
        }
        else
            throw new NoSuchElementException();
    }

    public E removeLast() {
        if (!isEmpty()) {
            E val = last.getInfo();
            if (size>1) {
                last.getPrev().setNext(null);
                last=last.getPrev();
                size--;
            }
            else if (size==1) {
                first=null;
                last=null;
                size--;
            }
            return val;
        }
        else
            throw new NoSuchElementException();
    }
    //incomplete code below
//handle empty list situation
    public E remove(int k) throws NoSuchElementException{
        if (!isEmpty()) {
            Node<E> temp = first;
            if ((k>=0) && (k<size)) {
                if (k==0) return removeFirst();
                else if (k==size-1) return removeLast();
                else {
                    // get to k
                    // int i=0;
                    for (int i=0;i<k;i++)
                        temp = temp.getNext();
                    E val=temp.getInfo();
                    temp.getPrev().setNext(temp.getNext());
                    temp.getNext().setPrev(temp.getPrev());
                    size--;
                    return val;
                }
            }
            else throw new IndexOutOfBoundsException();
        }
        else {
            System.out.println("list empty ..");
            throw new NoSuchElementException();
        }
    }
    // adds an item to the end of the list with info field set to val
    public void addLast(E val) {
        Node<E> n =new Node<>();
        n.setInfo(val);
        if (isEmpty())
            first = n;
        else {
            n.setPrev(last);
            last.setNext(n);
        }
        last = n;
        size++;
    }

    // prints all items in the list from first to last taking care of situations when the list is empty
    // use exception handling
    public void printListForward() throws NullPointerException{
        try {
            Node<E> temp = new Node<>();
            temp = first;
            while (temp.getNext() != null) {
                System.out.println(temp.getInfo());
                temp = temp.getNext();
            }
            System.out.println(temp.getInfo());
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    // prints all items in the list from last to first taking care of situations when the list is em
    // use exception handling
    public void printListBackward() throws NullPointerException {
        try {
            Node<E> temp = new Node<>();
            temp = last;
            while (temp.getPrev() != null) {
                System.out.println(temp.getInfo());
                temp = temp.getPrev();
            }
            System.out.println(temp.getInfo());
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    //returns true if and only if the list contains at least one element e such that
    //Objects.equals(o,e)
    //return false if the list is empty
    public boolean contains(Object o) {
        if(this.first != null) {
            Node<E> temp = new Node<>();
            temp = this.first;

            for (int i = 0; i < this.size; i++) {
                if (temp.getInfo() == o) {
                    return true;
                }
                temp = temp.getNext();
                i++;
            }
        }
        return false;
    }

    // brings the current list back to an empty list
    public void clear() {
        while(size > 0){
            this.removeFirst();
        }
    }
    // returns the info value stored at node i
    // throw IndexOutOfBounds exception of i is out of bounds or the list is empty
    public E get(int i) throws IndexOutOfBoundsException {
        Node<E> temp = new Node<>();
        temp = first;
        for(int j = 0; j < i; j++){
            temp = temp.getNext();
        }
        return temp.getInfo();

    }

    // compares this MyLinkedList with the parameter otherList
    // and returns true if the linkedlists have identical values from beginning to end
    // same size and this.get(i).equals(otherList.get(i)) should be true for all i
    // lists can be empty in which case return true
    //should run in O(n) time where n is the size of each list.
    public boolean equals(Object otherList) {
        int count = 0;
        if(otherList instanceof MyLinkedList){
            MyLinkedList<E> other = (MyLinkedList<E>) otherList;

            if(this.size == 0 && other.size == 0){
                return true;
            }

            if(this.size != other.size){
                return false;

            }else{

                for(int i = 0; i < this.size; i++){

                    if(this.get(i) == other.get(i)){
                        count++;
                    }
                }

                if(count == this.size - 1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){

    }
}