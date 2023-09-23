package fizzbuzz;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    private final static int MAX = 100;

    public static void main(String[] args) {

        ArrayList<Answer> answers = IntStream.rangeClosed(1, MAX)
            .mapToObj(AnswerCreater::create)
            .collect(Collectors.toCollection(ArrayList::new));

        answers.forEach(Answer::print);
    }
}

class AnswerCreater{
    static Answer create(int n){
        if(isFizzBuzz(n)){
            return new FizzBuzz();
        }else if(isFizz(n)){
            return new Fizz();
        }else if(isBuzz(n)){
            return new Buzz();
        }else{
            return new Number(n);
        }
    }

    static boolean isFizz(int n){
        return n % 3 == 0;
    }

    static boolean isBuzz(int n){
        return n % 5 == 0;
    }

    static boolean isFizzBuzz(int n){
        return isFizz(n) && isBuzz(n);
    }
}

abstract class Answer{
    String answer;
    Answer(String answer){
        this.answer = answer;
    }    
    void print(){
        System.out.println(answer);
    }
}
class Number extends Answer{
    Number(int n){
        super(String.valueOf(n));
    }
}
class FizzBuzz extends Answer{
    FizzBuzz(){
        super("FizzBuzz");
    }
}
class Fizz extends Answer{
    Fizz(){
        super("Fizz");
    }
}
class Buzz extends Answer{
    Buzz(){
        super("Buzz");
    }
}
