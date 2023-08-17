public class D4Q1 {

    public static void main(String[] args) {

        Queue<String> q1 = new CircularArrayQueue<String>(10);
        q1.enqueue("A");
        q1.enqueue("B");
        q1.enqueue("C");
        q1.enqueue("D");
        q1.enqueue("E");
        q1.enqueue("F");
        System.out.println(q1);
        q1.dequeue();
        q1.dequeue();
        System.out.println(q1);
        
        Queue<String> q2 = new CircularLinkedQueue<String>();
        q2.enqueue("A");
        q2.enqueue("B");
        q2.enqueue("C");
        q2.enqueue("D");
        q2.enqueue("E");
        q2.enqueue("F");
        System.out.println(q2);
        q2.dequeue();
        q2.dequeue();
        System.out.println(q2);

        Queue<String> q3 = new CircularArrayQueue<String>(5);        
        System.out.println(q3.toString());
        try {
            q3.dequeue();
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            q3.enqueue("E");
            q3.enqueue("F");
            q3.enqueue("G");
            q3.enqueue("H");
            q3.enqueue("I");
            q3.enqueue("J");
        }
        catch (RuntimeException e) {
            System.out.println(q3.toString());
            System.out.println(e.getMessage());
        }


        System.out.println("\n\n**************************TESTING CIRCULAR ARRAY QUEUE*****************************");
        CircularArrayQueue<String> q4 = new CircularArrayQueue<String>(10);
        q4.enqueue("A");
        q4.enqueue("B");
        q4.enqueue("C");
        q4.enqueue("D");
        q4.enqueue("E");
        q4.enqueue("F");
        System.out.println(q4);
        q4.dequeue();
        q4.dequeue();
        System.out.println("After dequeue: "+ q4);
        q4.rotate(2);
        System.out.println("\n\nAFTER ROTATION\n" + q4);


        System.out.println("\n\nTesting negative int...");
        CircularArrayQueue<String> q9 = new CircularArrayQueue<String>();
        try {
            q9.enqueue("A");
            q9.enqueue("B");
            q9.enqueue("C");
            q9.enqueue("D");
            q9.rotate(-1);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }





        System.out.println("\n\n**************************TESTING CIRCULAR LINKED QUEUE*****************************");
        CircularLinkedQueue<String> q5 = new CircularLinkedQueue<String>();
        q5.enqueue("A");
        q5.enqueue("B");
        q5.enqueue("C");
        q5.enqueue("D");
        q5.enqueue("E");
        q5.enqueue("F");
        System.out.println(q5);
        q5.dequeue();
        q5.dequeue();
        System.out.println("After dequeue: "+ q5);
        q5.rotate(1);
        System.out.println("\n\nAFTER ROTATION:\n" + q5);

        

        System.out.println("\n\nTesting negative int...");
        CircularLinkedQueue<String> q7 = new CircularLinkedQueue<String>();
        try {
            q7.enqueue("A");
            q7.enqueue("B");
            q7.enqueue("C");
            q7.enqueue("D");
            q7.rotate(-1);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }

    }    
}
