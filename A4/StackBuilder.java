public class StackBuilder {
    public static Stack<String> buildReverseStack(String[] array) { // {auto moto train velo}
		if (array == null )
			throw new IllegalStateException("Tableau est null");
        if ( array.length == 0)
            throw new IllegalStateException("Tableau est vide");
		return buildReverseStack(array, 0); //calls buildReverseStack({auto, moto, train, velo}, 0)
	}

    private static Stack<String> buildReverseStack (String[] array, int index) { //buildReverseStack({auto, moto, train, velo}, 0)
		if (index == array.length - 1) { 
			Stack<String> stack = new LinkedStack<String>(); 
		
            //TODO: Ajouter votre code ici.
            //vous n avez pas le droit d utiliser new ni creer d autres variables de type reference ou primitive
			
			stack.push(array[index]);
			return stack;
		} else { 
			Stack<String> stack;
			
            //TODO: Ajouter votre code ici.
            //vous n avez pas le droit d utiliser new ni creer d autres variables de type reference ou primitive
			
			stack = buildReverseStack(array, index + 1);
			stack.push(array[index]);

			return stack;
		}
	}
}