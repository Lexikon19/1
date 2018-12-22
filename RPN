import java.util.*;

public class RPNCalculator {
  private static Stack<Double> stack = new Stack<Double>();
  
  /**
   * Pushes a new value on the RPN stack.
   */
  void push(double v) {
    stack.push(v);
  }
  
  /**
   * Applies an arithmetic operation (on the operands pop-ed from the top of
   * the stack), pushes the result on the stack.
   */
  void apply(String cmd) {
    double a;
    double b;

    switch (cmd) {
      case "~": //  (tilde) unary minus
        stack.push(-stack.pop());
        break;
      case "+": // plus
        b = stack.pop();
        a = stack.pop();
        stack.push(a + b);
        break;
      case "-": // minus
        b = stack.pop();
        a = stack.pop();
        stack.push(a - b);
        break;
      case "*": // multiply
        b = stack.pop();
        a = stack.pop();
        stack.push(a * b);
        break;
      case "/": // divide
        double divisor = stack.pop();
        double dividend = stack.pop();
        if (divisor == 0){
          Out.println("forbidden division by zero ");
          stack.push(divisor);
          stack.push(dividend);
        }
        else{
          stack.push(dividend / divisor);
        }
        break;
      default:
        assert false : "invalid command";
    }
  }
  
  /**
   * Pops a value from the RPN stack.
   */
  double pop() {
    return stack.pop();
  }
}
