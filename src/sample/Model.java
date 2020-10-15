package sample;

public class Model {

    public long calculate(int a, int b, String operator){
        return switch (operator){
            case "-" -> a-b;
            case "*" -> a*b;
            case "+" -> a+b;
            case "/" -> {if(b == 0)yield 0; yield a/b;}
            default -> throw new IllegalStateException("Неизвестный оператор: " + operator);
        };
    }

}
