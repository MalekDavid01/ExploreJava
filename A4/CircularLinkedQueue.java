public class CircularLinkedQueue<E> implements Queue<E> {

    private static class Elem<T> {

        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public CircularLinkedQueue () {
        front = rear = null;
    }

    private Elem<E> front;
    private Elem<E> rear;

    public void enqueue(E value) {

        if (value == null) {
            throw new NullPointerException();
        }

        Elem<E> newElem;
        newElem = new Elem<E>(value, null );

        if (rear == null) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
    }

    public E peek() {
        return front.value;
    }

    public E dequeue() {
        E result = front.value;

        if (front.next == null) {
            front = rear = null;
        } else {
            front = front.next;
        }

        return result;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void rotate (int n) {
        //TODO: Mettez votre code ici
        //vous ne devez pas utiliser les méthodes d’instance de cette classe
        
        if ( n < 0){
            throw new IllegalArgumentException("Must be positive int");
        }

        if ( front == null ) { ///////////////////////to check
            throw new RuntimeException("EmptyQueueException");
        }
        int i = 0;
        while (i<n){
            E saved = front.value;
            Elem<E> move;
            move = new Elem<E> (saved, null);
            if (front.next == null) {
                front = rear = null;
            } 
            else {
            front = front.next;
            }

            if (rear == null) {
                front = rear = move;
            } 
            else {
                rear.next = move;
                rear = rear.next;
            }

            i++;
        }
    }

    @Override
    public String toString() {
        String str = "[";
        Elem<E> p = front;

        while (p != null) {
            if (p != front) {
                str += ", ";
            }
            str += p.value;
            p = p.next;
        }
        str += "]";
        return str;
    }
}
