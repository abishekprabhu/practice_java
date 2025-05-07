
@java.lang.FunctionalInterface
interface Greetings{
    //void empty();
    void greet(String message);

    default void default_method(){
        System.out.println("Default");
    }

    static void static_method(){
        System.out.println("static method");
    }
    String toString();
}

class GreetingImpl implements Greetings{
    @Override
    public void greet(String message){
        System.out.println("Hello"+ message);
    }
}

public class FunctionalInterface {
    public static void main(String[] args) {
        Greetings lambda = (msg)->{
            System.out.println("lambda says hi "+msg);
        };

       // Greetings lambda1 = ()->"empty String";
        Greetings service = new GreetingImpl();
        service.greet(" world");
        lambda.greet("Abishek");
        service.toString(); //ignored
        service.default_method();
        Greetings.static_method();
    }
}

