package lotto;

import java.util.List;

public class Bonus {
    public final int number;

    public Bonus(String inputBonusNumber, List<Integer> lotto){
        int number = convertNumber(inputBonusNumber);

        validateBonusNumberRange(number);
        validateBonusNumber(number, lotto);
        this.number = number;
    }

    public int getBonus () {
        return this.number;
    }

    public int convertNumber(String inputBonusNumber) {
        int number;

        isRealNumber(inputBonusNumber);
        number = Integer.parseInt(inputBonusNumber);

        return number;
    }

    public void validateBonusNumberRange(int lottoBonusNumber){
        if (lottoBonusNumber < 1 || lottoBonusNumber > 45){
            throw new IllegalArgumentException("[ERROR]: 보너스 번호는 반드시 1~45 이내에 숫자여야 합니다.");
        }
    }

    public void validateBonusNumber(int lottoBonusNumber, List<Integer> lotto){
        if (lotto.contains(lottoBonusNumber)){
            throw new IllegalArgumentException("[ERROR]: 보너스 번호는 입력한 당첨번호와 중복되어선 안됩니다.");
        }
    }

    private void isRealNumber (String inputStatement) {
        for (char element: inputStatement.toCharArray()) {
            if (element < 48 || element > 57) {
                throw new IllegalArgumentException("[ERROR]: 숫자만 입력할 수 있습니다.");
            }
        }
    }
}