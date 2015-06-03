package miniMathematica;

import java.util.ArrayDeque;

/**
 * 
 * @author Jivko Todorov
 * 
 * @see GlobalFunctions/isHigherPrecedence - this method is not created by me. I
 *      found it at
 *      "http://eddmann.com/posts/shunting-yard-implementation-in-java/". The
 *      reason I used this instead of my own method is because my own did not
 *      work as expected and my calculations were wrong using it.
 * 
 */

public class Main extends ReversePolish {
	public static void main(String[] args) {

		long start = System.nanoTime();

		ArrayDeque<String> check = refactorUserInput("5 + sin(-pi) / pow(2, 10) - log(e, pow(e, sqrt(4)))");
		System.out.println(postfixToReversePolish(shuntingYard(check)));

		System.out.println(System.nanoTime() - start);

	}
}
