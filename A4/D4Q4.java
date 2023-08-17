public class D4Q4 {
    public static void main (String[] args) {
		String[] array = {"auto", "moto", "train", "velo"};		
        
        Stack<String> stack;                               // auto est le dernier element qui va etre insere dans la pile et sera donc au top de la pile,
		stack = StackBuilder.buildReverseStack(array);	   // velo est le premier element qui est insere dans la pile et sera donc au fond de la pile
                                                  
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");   // affichera donc auto (top) , moto,  train, velo(bottom) 
        }        
	}   
}
