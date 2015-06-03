package miniMathematica;

import java.util.ArrayDeque;

public class RefactorInput extends GlobalFunctions {

	private static ArrayDeque<String> refactoredTokens = new ArrayDeque<String>();
	private static StringBuilder wordContainer = new StringBuilder();
	private static StringBuilder numberContainer = new StringBuilder();
	private static char[] inputChar;

	public static ArrayDeque<String> refactorUserInput(String input) {

		input = input.replaceAll("log\\(e,", "log(");
		input = input.replaceAll("\\s", "");

		inputChar = input.toCharArray();
		int charLength = inputChar.length;

		for (int i = 0; i < charLength; i++) {

			if (isAcceptedChar(inputChar[i])) {
				wordContainer.append(inputChar[i]);
			} else if (wordContainer.length() != 0) {
				refactoredTokens.add(wordContainer.toString());
				wordContainer.setLength(0);
			}

			if (Character.isDigit(inputChar[i]) || inputChar[i] == '.') {
				numberContainer.append(inputChar[i]);
			} else if (numberContainer.length() > 0) {
				refactoredTokens.add(numberContainer.toString());
				numberContainer.setLength(0);
			}

			if (inputChar[i] == '-'
					&& (i == 0 || inputChar[i - 1] == ',' || inputChar[i - 1] == '(')) {
				if (Character.isDigit(inputChar[i + 1])) {
					numberContainer.append('-');
				} else if (Character.isAlphabetic(inputChar[i + 1])) {
					wordContainer.append('-');
				}
			} else if (allowedOper.contains(inputChar[i])) {
				refactoredTokens.add(Character.toString(inputChar[i]));
			}
		}

		if (numberContainer.length() != 0) {
			refactoredTokens.add(numberContainer.toString());
		}
		if (wordContainer.length() != 0) {
			refactoredTokens.add(wordContainer.toString());
		}
		wordContainer.setLength(0);
		numberContainer.setLength(0);
		return refactoredTokens;
	}

}
