public class D4Q3 {

    public static void main(String[] args) {

        LinkedList<String> r= new LinkedList<String>();

		r.add("A", 0);
        r.add("B", 1);
        r.add("C", 2);
        System.out.println(r);

        Iterator<String> d = r.iterator();

        int m = 0;
        while(d.hasNext() && m<6){ //print A, B, C twice
            System.out.println(d.next());
            m++;
        }


        System.out.println("\nother test 2");

        LinkedList<String> k= new LinkedList<String>();

		k.add("A", 0);
        k.add("B", 1);
        k.add("C", 2);
        System.out.println(k);

        Iterator<String> t = k.iterator();

        int n = 0;
        while(t.hasPrev() && n<6){ //print C, B, A twice
            System.out.println(t.prev());
            n++;
        }


        System.out.println("\nother test 3");
		LinkedList<String> l= new LinkedList<String>();

		l.add("A", 0);
        l.add("B", 1);
        l.add("C", 2);
        System.out.println(l);

        Iterator<String> i = l.iterator();
        
     


        System.out.println(i.next()); // affiche A
        System.out.println(i.next()); // affiche B
        System.out.println(i.next()); // affiche C
        System.out.println(i.next()); // boucle vers l’avant et affiche A
        System.out.println(i.next()); // affiche B
        System.out.println(i.prev()); // affiche A
        System.out.println(i.prev()); // boucle vers l’arrière et affiche C
        System.out.println(i.prev()); // affiche B		
    }    
}
