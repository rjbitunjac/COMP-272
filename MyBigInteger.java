public class MyBigInteger{

    MyLinkedList<Integer> bigI;

    public MyBigInteger () {
        bigI =new MyLinkedList<>();
    }

    // takes a numerically valued String p and stores it one digit at a time in the linked list
    // example, MyBigInteger("383023322") will store the integer 383023322 in the linked list
    // one digit per node.
    public MyBigInteger(String p) {
        bigI = new MyLinkedList<>();
        char[] arr = p.toCharArray();

        for(char c : arr){
            bigI.addLast(c - 48); // Because ASCII is stupid and 0 is 48
        }
    }

    //add(..) adds this MyBigInteger to other MyBigInteger and returns the sum as a MyBigInteger
    // the original Big Integers don't change.
    // Adds like humans would: find the sum of the right most digits, and add carry values as needed
    public MyBigInteger add(MyBigInteger other) {

        MyBigInteger result = new MyBigInteger();
        MyLinkedList<Integer> biggerList; // The bigger of the two lists, so I know which one to iterate through in the for loop
        MyLinkedList<Integer> smallerList; // The smaller of the two lists, to identify the list that is not biggest

        int sum = 0; // Stores the sum of the two values currently being added
        int ones = 0; // Stores the value of the sum's "one's place"
        int tens = 0; // Stores the value of the sum's "ten's place" (if there is one, if not just 0)
        int biggerListSize; // Size of biggerList
        int smallerListSize; // Size of smallerList

        //Block of code that determines which list (this or other) is bigger, and assigns variables accordingly
        if(this.bigI.size >= other.bigI.size){
            biggerList = this.bigI;
            biggerListSize = this.bigI.size;
            smallerList = other.bigI;
            smallerListSize = other.bigI.size;
        }else{
            biggerList = other.bigI;
            biggerListSize = other.bigI.size;
            smallerList = this.bigI;
            smallerListSize = this.bigI.size;
        }

        // Adding happens in this for loop
        for(int i = 1; i <= biggerListSize; i++){

            // checks that there are still valid digits in smallerList to add
            if((smallerListSize - i) >= 0){
                sum += biggerList.get(biggerListSize - i) + smallerList.get(smallerListSize - i); // sum = sum + the rightmost uncalculated sum of both lists
                ones = sum % 10;
                tens = (sum % 100) / 10;
                sum = 0 + tens; // Stores the tens place digit in sum for later calculations so it is not lost on new iteration of for loop
                result.bigI.addFirst(ones);
            }else{
                sum += biggerList.get(biggerListSize - i);
                result.bigI.addFirst(sum);
            }
        }
        for(int i = 0; i < result.bigI.size; i++){
            System.out.print(result.bigI.get(i));
        }
        return result;
    }

    // returns true if and only if the two big integers are equal
    public boolean equals(Object other) {

        boolean areEqual = false;

        if(other instanceof MyBigInteger){
            MyBigInteger o = (MyBigInteger) other;

            if(this.bigI.size != o.bigI.size){
                return false;
            }else{
                for(int i = 0; i < this.bigI.size; i++){

                    if(this.bigI.get(i) != o.bigI.get(i)){
                        return false;
                    }else{
                        areEqual = true;

                        if(this.bigI.get(i) == o.bigI.get(i) && areEqual && i == this.bigI.size - 1){
                            return true;
                        }
                    }
                }
            }
        }else{
            return false;
        }
        return areEqual;
    }

    // returns true if and only if this MyBigInteger is less than other MyBigInteger
    public boolean lessThan(MyBigInteger other) {

        boolean isLessThan = false;

        if(this.bigI.size > other.bigI.size){
            return false;

        }else if(this.bigI.size < other.bigI.size){
            return true;
        }else{
            for(int i = 0; i < this.bigI.size; i++){

                if(this.bigI.get(i) > other.bigI.get(i)){
                    return false;

                }else if(this.bigI.get(i) <= other.bigI.get(i)){
                    isLessThan = true;

                    if(this.bigI.get(i) == other.bigI.get(i) && (i == this.bigI.size - 1)){
                        return false;
                    }
                }
            }
        }
        return isLessThan;
    }

    public static void main(String[] args) {
        MyBigInteger test = new MyBigInteger("98765");
        MyBigInteger test2 = new MyBigInteger("98765");
        System.out.println(test.equals(test2));
    }
}