import java.util.LinkedList;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    HashMap<String,Integer> operatorPrecedence = new HashMap<String,Integer>();
    operatorPrecedence.put("~", 3);
    operatorPrecedence.put("*", 2);
    operatorPrecedence.put("/", 2);
    operatorPrecedence.put("+", 1);
    operatorPrecedence.put("-", 1);
    
    RPNCalculator rpn = new RPNCalculator();
    // TODO ...
    LinkedList<String> commandStack = new LinkedList<>();
    while (true) {
      String next = In.readWord();
      if (next.equals("=")) {
        break;
      }
      Integer op = operatorPrecedence.get(next);
      if (op != null) { // it was an operator
        // TODO ...
        if(!commandStack.isEmpty()){
          int prec2 = operatorPrecedence.get(commandStack.peek());
          int prec1 = op;
          if((prec2 > prec1) || (prec2 == prec1)){
            rpn.apply(commandStack.pop());
            commandStack.push(next);
          }else{
            commandStack.push(next);
          }
        }else if(commandStack.isEmpty()){
          commandStack.push(next);
        }
      } else { // enter a number, will run into exception if no number
        // TODO ...
        double number = Double.parseDouble(next);
        rpn.push(number);
      }
    }
    // TODO ...
    while(!commandStack.isEmpty()){
      rpn.apply(commandStack.pop());
    }
    Out.print("> "); Out.print(rpn.pop(), 1); Out.println(" <");
  }
}
