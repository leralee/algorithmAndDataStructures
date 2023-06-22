import java.util.Scanner;
import java.util.Stack;
// ID 88414885
/**
 * @author valeriali on {20.06.2023}
 * @project algorithms
 */

/**
Принцип работы алгоритма:

Входное выражение разбивается на отдельные символы или операторы.
Для каждого символа:
Если символ является оператором, извлекаем два последних операнда из стека,
выполняем операцию с использованием оператора и помещаем результат обратно в стек.
Если символ является операндом, помещаем его в стек.
После обработки всего выражения, результат вычисления находится на вершине стека и извлекается для возврата.
Корректность алгоритма обосновывается следующими фактами:

Использование стека позволяет сохранять операнды и промежуточные результаты в правильном порядке.
При корректном входном выражении, где операнды и операторы записаны правильно, алгоритм даст правильный результат.
Оценка временной сложности:

Разбиение выражения на символы занимает O(n), где n - количество символов в выражении.
Перебор каждого символа и выполнение операций занимают O(n).
Всего выполняется n операций, где n - количество символов в выражении.
Следовательно, временная сложность алгоритма составляет O(n).

Оценка пространственной сложности:

Для хранения операндов и промежуточных результатов используется стек.
В худшем случае, стек может содержать все операнды выражения.
Следовательно, пространственная сложность алгоритма составляет O(n).
*/


public class CalculatorSolution {

    public static int evaluateExpression(String expression){
        Stack<Integer> stack = new Stack<>();

        for (String symbol : expression.split("\\s+")){
            if (isOperator(symbol)){
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(symbol, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(symbol));
            }
        }
        return stack.pop();
    }

    public static boolean isOperator(String symbol){
        return symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/");
    }

    public static int performOperation(String operator, int operand1, int operand2){
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return (int) Math.floor((double) operand1 / operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        int result = evaluateExpression(expression);
        System.out.println(result);
    }
}
