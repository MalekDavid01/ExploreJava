 public class LinkedList<E> implements List<E> {

    private static class Node<T> {
      private T value;
      private Node<T> prev;
      private Node<T> next;
      private Node(T value, Node<T> prev, Node<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
      }
    }
    
    private Node<E> head;
    private int size;
    
    public LinkedList() {
        head = new Node<E>(null, null, null);
        head.prev = head;
        head.next = head;
        size = 0;
    }

    public int size() {
      return size;
    }
 
    public E get(int pos) {
 
      if (pos < 0 || pos >= size) {
        throw new IndexOutOfBoundsException(Integer.toString(pos));
      }
      
      Node<E> p;
      p = head.next;
      
      while (pos > 0) {
        p = p.next;
        pos--;
      }

      return p.value;
    }

    public void add(E element, int pos) {

      if (element == null) {
        throw new NullPointerException();
      }
      
      if (pos < 0 || pos > size) {
        throw new IndexOutOfBoundsException(Integer.toString(pos));
      }
      
      Node<E> before, after;
      before = head;
      
      while (pos > 0) {
        before = before.next;
        pos--;
      }

      after = before.next;
      
      before.next = new Node<E>(element, before, after);
      after.prev = before.next;
      
      size++;
    }

    public void remove(int pos) {

      if (pos < 0 || pos >= size) {
        throw new IndexOutOfBoundsException(Integer.toString(pos));
      }
      
      Node<E> before, after;
      before = head;
      
      while (pos > 0) {
        before = before.next;
        pos--;
      }
      
      after = before.next.next;
      
      before.next = after;
      after.prev = before;
      
      size--;
    }

    public boolean remove(E element) {
 
      if (element == null) {
        throw new NullPointerException();
      }
      
      Node<E> p, before, after;
      p = head.next;
      
      while (p != head && ! p.value.equals(element)) {
        p = p.next;
      }
      
      if (p == head) {
        return false;
      }
      
      before = p.prev;
      after = p.next;
      
      before.next = after;
      after.prev = before;
      
      size--;
      
      return true;
    }

    public LinkedList<E> splitAfter (E obj) {
        //TODO: Ajouter votre code ici.
        //vous n avez pas le droit d appeler les methodes d instances de cette classe sauf le constructeur..
        
        // New list to stack elements from second split
        LinkedList<E> second = new LinkedList<E>(); //new list

        if (size == 0){
          return second;
        }

        // p points to the first element in the list
        Node<E> p;
        p = head.next;
        
        //checking and setting p to point to the element for which its value is equal to obj
        int i = 1;
        while (!p.value.equals(obj) && i<this.size){
          p = p.next;
          i++;
        }
        
        //throw error if there is no such element in the list
        if (!p.value.equals(obj)){
          throw new IllegalArgumentException("Object not found in list");
        }

        //if p is the last element in the list
        if (p == head.prev){ 
          return second;
        }
        else{
          second.head.next = p.next; //point dummy node of new list to first element following obj
          second.head.prev = head.prev; // point the previous pointer to the last element of list 1

          //Unlinking
          p.next.prev = second.head; //link the previous pointer of the first element following obj to the dummy node of list 2
          p.next = head; // link obj to head of dummy node of list 1
          second.head.prev.next = second.head; //link last element of list 1 to head of list 2
          head.prev = p;

          return second;
        }
    }







    //TODO: Ajouter votre code ici pour l iterateur 

    private class LinkedListIterator implements Iterator<E> {
      private Node<E> current = head;

      public boolean hasNext() {
        return (size!=0);
      }

      public boolean hasPrev() {
        return (size!=0);
      }

      public E next() {        
        if (size ==0)  {
          return null;
        }
        current = current.next;
        if (current == head) {
          current = current.next;
        }
        return current.value;
      }

      public E prev() {
        if (size ==0)  {
          return null;
        }
        current = current.prev;
        if (current == head) {
          current = current.prev;
        }
        return current.value;
      }
    }


    public Iterator<E> iterator() {
      return new LinkedListIterator();
    }


    public String toString() {

      StringBuffer b;
      b = new StringBuffer("LinkedList [");
      
      Node<E> p;
      p = head.next;
      
      while (p != head) {
        b.append(p.value);
        if (p.next != head) {
          b.append(",");
        }
        p = p.next;
      }
      
      b.append("]");
      
      return b.toString();
    }
    
    
}
