package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String inputLottoNumber) {
        List<Integer> numbers = convertNumbers(inputLottoNumber);

        validateLottoNumberCount(numbers);
        validateLottoNumberRange(numbers);
        validateLottoNumberDuplicated(numbers);
        this.numbers = numbers;
    }

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
        validateLottoNumberRange(lottoNumbers);
        validateLottoNumberDuplicated(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumberCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]: 로또 당첨 숫자에는 6개를 입력해주세요");
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (int number: numbers){
            if (number < 1 || number > 45) throw new IllegalArgumentException("[ERROR]: 로또 당첨 숫자에는 1이상 45이하의 숫자를 입력해주세요.");
        }
    }

    private void validateLottoNumberDuplicated(List<Integer> numbers) {
        HashSet<Integer> DuplicatedNumber = new HashSet<>(numbers);

        if (DuplicatedNumber.size() < 6){
            throw new IllegalArgumentException("[ERROR]: 로또 당첨 숫자에는 중복된 숫자를 입력하면 안됩니다.");
        }
    }

}
