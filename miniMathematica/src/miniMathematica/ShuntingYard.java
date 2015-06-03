package miniMathematica;

import java.util.ArrayDeque;

public class ShuntingYard extends RefactorInput {
    private static ArrayDeque<String> queue = new ArrayDeque<String>();
    private static ArrayDeque<String> stack = new ArrayDeque<String>();

    public static ArrayDeque<String> shuntingYard(ArrayDeque<String> check) {

        for (String s : check) {

            if (isNumber(s) || constants.contains(s)) {
                queue.add(s);
            }

            else if (functions.contains(s)) {
                stack.push(s);
            }

            else if (areEqual(s, COMMA)) {
                while (!areEqual(stack.peek(), LEFT_BRACKET)) {
                    queue.add(stack.pop());
                }
            }

            else if (operators.contains(s)) {
                while (!stack.isEmpty() && isHigherPrecedence(s, stack.peek())) {
                    queue.add(stack.pop());
                }
                stack.push(s);
            }

            else if (areEqual(s, LEFT_BRACKET)) {
                stack.push(LEFT_BRACKET);
            }

            else if (areEqual(s, RIGHT_BACKET)) {
                while (!stack.isEmpty() && !(areEqual(stack.peek(), LEFT_BRACKET))) {
                    queue.add(stack.pop());
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }

                if (!stack.isEmpty() && functions.contains(stack.peek())) {
                    queue.add(stack.pop());
                }

            } else {
                queue.add(s);
            }

        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }
}
