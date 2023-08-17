public class D4Q2 {

    public static void main(String[] args) {
		/*
		List<Integer> l;
		l = new LinkedList<Integer>();

		System.out.println(l);
		System.out.println(l.size());

		for (int i=0; i<5; i++) {
			l.add(i, 0);
			System.out.println(l);
			System.out.println(l.size());
		}

		for (int i=0; i<5; i++) {
			l.add(i+5, i);
			System.out.println(l);
			System.out.println(l.size());
		}

		l.add(11, l.size());
		System.out.println(l);
		System.out.println(l.size());
		
		for (int i=0; i<5; i++) {
			l.remove(i);
			System.out.println(l);
			System.out.println(l.size());
		}

		l.remove(l.size()-1);
		System.out.println(l);
		System.out.println(l.size());

		l.remove(Integer.valueOf(6));
		l.remove(Integer.valueOf(6));
		System.out.println(l);
		System.out.println(l.size());

		l.remove(Integer.valueOf(0));
		System.out.println(l);
		System.out.println(l.size());

		l.remove(Integer.valueOf(4));
		System.out.println(l);
		System.out.println(l.size());

		l.remove(Integer.valueOf(8));
		System.out.println(l);
		System.out.println(l.size());

		l.remove(Integer.valueOf(2));
		System.out.println(l);
		System.out.println(l.size());
		*/
		LinkedList<String> p;
		p = new LinkedList<String>();

		p.add("A", 0);
		p.add("B", 1);
		p.add("C", 2);
		p.add("D", 3);
		p.add("E", 4);
		p.add("F", 5);
		p.add("G", 6);
		
		System.out.println("Initial: " + p);
		
		LinkedList<String> q = p.splitAfter("D");
		System.out.println("p: " + p);
		System.out.println("q: " + q);


		LinkedList<String> A;
		A = new LinkedList<String>();
		
		A.add("A", 0);
		A.add("B", 1);
		A.add("C", 2);
		A.add("D", 3);
		A.add("C", 4);
		A.add("E", 5);
		A.add("D", 6);
		
		System.out.println("Initial: " + A);
		
		LinkedList<String> B = A.splitAfter("D");
		System.out.println("A: " + A);
		System.out.println("B: " + B);



    }    
}
