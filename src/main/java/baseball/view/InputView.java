package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine().trim();
        validateAllNumbers(input);
        return input;
    }

    public String inputRestartNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine().trim();
        validateRestartNumber(input);
        return input;
    }

    private void validateAllNumbers(String inputNumbers) {
        validateNotBlank(inputNumbers);
        validateNoWhiteSpaceInNumber(inputNumbers);
        validateIsNumeric(inputNumbers);
    }

    private void validateRestartNumber(String input) {
        validateAllNumbers(input);

        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
        }
    }

    private void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어 있거나 공백일 수 없습니다.");
        }
    }

    private void validateNoWhiteSpaceInNumber(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("숫자 내부에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateIsNumeric(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
