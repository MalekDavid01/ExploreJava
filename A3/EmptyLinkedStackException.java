public class EmptyLinkedStackException extends java.util.EmptyStackException{
    public EmptyLinkedStackException(){
        System.out.println("La pile utilisant une liste chainée est vide");
    }

    public EmptyLinkedStackException(String modified){
        System.out.println(modified);
    }

}