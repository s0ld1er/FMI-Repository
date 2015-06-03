package miniMathematica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GlobalFunctions {

	private static final Character[] ALLOWED_CHARS = { 's', 'q', 'r', 't', 'l',
			'o', 'g', 'i', 'n', 'c', 'p', 'w', 'a', 'e' };
	private static final Character[] ALLOWED_OPER = { '+', '-', '*', '/', '(',
			')', ',' };
	private static final String[] SET_FUNCTIONS = { "pow", "log", "sqrt",
			"sin", "cos", "tg", "cotg", "-pow", "-log", "-sqrt", "-sin",
			"-cos", "-tg", "-cotg" };
	private static final String[] CONST_STRINGS = { "pi", "-pi", "e", "-e" };
	private static final String[] OPERATORS = { "+", "-", "*", "/" };

	public static final Set<Character> allowedChars = new HashSet<Character>(
			Arrays.asList(ALLOWED_CHARS));
	public static final Set<Character> allowedOper = new HashSet<Character>(
			Arrays.asList(ALLOWED_OPER));
	public static final Set<String> operators = new HashSet<String>(
			Arrays.asList(OPERATORS));
	public static final Set<String> constants = new HashSet<String>(
			Arrays.asList(CONST_STRINGS));
	public static final Set<String> functions = new HashSet<String>(
			Arrays.asList(SET_FUNCTIONS));

	protected static final String LEFT_BRACKET = "(";
	protected static final String RIGHT_BACKET = ")";
	protected static final String COMMA = ",";

	private enum Operator {
		ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);
		final int precedence;

		Operator(int p) {
			precedence = p;
		}
	}

	@SuppressWarnings("serial")
	private static HashMap<String, Operator> operats = new HashMap<String, Operator>() {
		{
			put("+", Operator.ADD);
			put("-", Operator.SUBTRACT);
			put("*", Operator.MULTIPLY);
			put("/", Operator.DIVIDE);
		}
	};

	public static boolean isHigherPrecedence(String op, String sub) {
		return (operats.containsKey(sub) && operats.get(sub).precedence >= operats
				.get(op).precedence);
	}

	public static boolean areEqual(final String firstString,
			final String secondString) {
		return firstString.length() == secondString.length()
				&& firstString.equals(secondString);
	}

	@SuppressWarnings("unused")
	public static boolean isNumber(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static boolean isAcceptedChar(char character) {
		return allowedChars.contains(character);
	}

}
