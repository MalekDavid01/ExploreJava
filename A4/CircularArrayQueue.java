public class CircularArrayQueue<E> implements Queue<E> {

    public static final int DEFAULT_CAPACITY = 100;
    private final int MAX_QUEUE_SIZE;
    private E[] elems;
    private int front;
    private int rear;

    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    @SuppressWarnings ("unchecked")
    public CircularArrayQueue(int capacity ) {
        if (capacity < 0) {
            throw new IllegalArgumentException( Integer.toString( capacity ) );
        }
        MAX_QUEUE_SIZE = capacity;
        elems = (E []) new Object[ MAX_QUEUE_SIZE ];
        front = 0;
        rear = -1; // Représente une file vide
    }

    public boolean isEmpty() {
        return ( rear == -1 );
    }
    
    public boolean isFull() {
        return ( ! isEmpty() ) && nextIndex( rear ) == front;
    }
    
    private int nextIndex(int index) {
        return ( index+1 ) % MAX_QUEUE_SIZE;
    }

    public void enqueue( E o ) {
        if ( o == null ) {
            throw new IllegalArgumentException( "null" );
        }
        if ( isFull() ) {
            throw new RuntimeException("QueueOverflowException");
        }
        rear = nextIndex( rear );
        elems[ rear ] = o;
    }


    public E dequeue() {
        if ( isEmpty() ) {
            throw new RuntimeException("EmptyQueueException");
        }
        E result = elems[ front ];
        elems[ front ] = null; // Pour la gestion de la m´emoire
        if ( front == rear ) { // Suite `a cet appel, la file sera vide
            front = 0;
            rear = -1;
        } else {
            front = nextIndex( front );
        }
        return result;
    }

    public void rotate (int n) {
        //TODO: Mettez votre code ici
        //vous ne devez pas utiliser les méthodes d’instance de cette classe
        
        if ( n < 0){
            throw new IllegalArgumentException("Must be positive int");
        }

        if ( rear == -1 ) { ///////////////////////to check
            throw new RuntimeException("EmptyQueueException");
        }

        int i = 0;
        while (i<n){

          

            //dequeue
            E saved = elems[front];
            elems [front] = null;
            if (front == rear){
                front = 0;
                rear = -1;
            }
            else {
                front = ( front +1 ) % MAX_QUEUE_SIZE;
            }

            //enqueue
            rear = ( rear+1 ) % MAX_QUEUE_SIZE;
            elems[rear] = saved;
            i++;


        }

    }

    @Override
    public String toString() {
        
        String str = "[";
        int index = front;

        if (rear!= -1) {
            while (index!=rear) {
                str += elems [index];
                str += ", "; 
                index = nextIndex(index);
            }
            str+=elems [index];
        }
        str += "]";

        return str;
    }
}
