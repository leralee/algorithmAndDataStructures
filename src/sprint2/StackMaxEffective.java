package sprint2;

import java.util.*;

/**
 * @author valeriali on {17.06.2023}
 * @project algorithms
 */

class Stack {
    private LinkedList<Integer> stack;  // стек для хранения элементов
    private LinkedList<Integer> maxStack;  // стек для хранения текущего максимального значения

    public Stack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);

        // Обновляем стек максимальных значений
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    public String pop() {
        if (stack.isEmpty()) {
            return "error";
        }

        int poppedElement = stack.pop();

        // Если удаляемое значение равно текущему максимальному значению,
        // удаляем его из стека максимальных значений
        if (poppedElement == maxStack.peek()) {
            maxStack.pop();
        }

        return "";
    }

    public String getMax() {
        if (stack.isEmpty()) {
            return "None";
        }

        return String.valueOf(maxStack.peek());
    }
}

public class StackMaxEffective {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();  // Считываем перевод строки после числа команд
        Stack stackMax = new Stack();
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            if (command.startsWith("push")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                stackMax.push(x);
            } else if (command.equals("pop")) {
                String result = stackMax.pop();
                if (result.equals("error")) {
                    System.out.println("error");
                }
            } else if (command.equals("get_max")) {
                System.out.println(stackMax.getMax());
            }
        }
    }
}



