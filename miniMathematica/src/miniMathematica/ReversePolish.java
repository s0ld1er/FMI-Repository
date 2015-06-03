package miniMathematica;

import java.util.ArrayDeque;

public class ReversePolish extends ShuntingYard {
	private static ArrayDeque<Double> finalResult = new ArrayDeque<Double>();

	public static double postfixToReversePolish(
			ArrayDeque<String> refactoredTokens) {

		while (!refactoredTokens.isEmpty()) {
			String currentToken = refactoredTokens.remove();

			if (isNumber(currentToken)) {
				finalResult.push(Double.valueOf(currentToken));
			}
			switch (currentToken) {
			case "+":
				double firstAdd = finalResult.pop();
				double secondAdd = finalResult.pop();
				finalResult.push(firstAdd + secondAdd);
				break;
			case "-":
				double firstValue = finalResult.pop();
				double secondValue = finalResult.pop();
				finalResult.push(secondValue - firstValue);
				break;
			case "*":
				double firstMult = finalResult.pop();
				double secondMult = finalResult.pop();
				finalResult.push(firstMult * secondMult);
				break;
			case "/":
				double firstDiv = finalResult.pop();
				double secondDiv = finalResult.pop();
				finalResult.push(secondDiv / firstDiv);
				break;
			case "pi":
				finalResult.push(Math.PI);
				break;
			case "-pi":
				finalResult.push(-Math.PI);
				break;
			case "e":
				finalResult.push(Math.E);
				break;
			case "-e":
				finalResult.push(-Math.E);
				break;
			case "pow":
				double firstPow = finalResult.pop();
				double secondPow = finalResult.pop();
				finalResult.push(Math.pow(secondPow, firstPow));
				break;
			case "-pow":
				double firstNegPow = finalResult.pop();
				double secondNegPow = finalResult.pop();
				finalResult.push(-Math.pow(secondNegPow, firstNegPow));
				break;
			case "sqrt":
				double sqrtNum = finalResult.pop();
				finalResult.push(Math.sqrt(sqrtNum));
				break;
			case "-sqrt":
				double sqrtNegNum = finalResult.pop();
				finalResult.push(-Math.sqrt(sqrtNegNum));
				break;
			case "log":
				double logNum = finalResult.pop();
				finalResult.push(Math.log(logNum));
				break;
			case "-log":
				double logNegNum = finalResult.pop();
				finalResult.push(-Math.log(logNegNum));
				break;
			case "sin":
				double sinNum = finalResult.pop();
				finalResult.push(Math.sin(sinNum));
				break;
			case "-sin":
				double sinNegNum = finalResult.pop();
				finalResult.push(-Math.log(sinNegNum));
				break;
			case "cos":
				double cosNum = finalResult.pop();
				finalResult.push(Math.cos(cosNum));
				break;
			case "-cos":
				double cosNegNum = finalResult.pop();
				finalResult.push(-Math.cos(cosNegNum));
				break;
			case "tan":
				double tanNum = finalResult.pop();
				finalResult.push(Math.tan(tanNum));
				break;
			case "-tan":
				double tanNegNum = finalResult.pop();
				finalResult.push(-Math.tan(tanNegNum));
				break;
			case "cotan":
				double cotanNum = finalResult.pop();
				finalResult.push(1 / Math.tan(cotanNum));
				break;
			case "-cotan":
				double cotanNegNum = finalResult.pop();
				finalResult.push(-1 / Math.tan(cotanNegNum));
				break;
			default:
				break;
			}
		}

		if (finalResult.size() == 1) {
			return finalResult.pop();
		} else {
			throw new IllegalArgumentException();
		}
	}
}
