package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public void printResult (HashMap<Integer, Integer> prizeRankings, double totalProfit) {

        System.out.printf("3개 일치 (5,000원) - %d개\n", prizeRankings.get(Ranking.FIFTH.getPrize()));
        System.out.printf("4개 일치 (50,000원) - %d개\n", prizeRankings.get(Ranking.FORTH.getPrize()));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", prizeRankings.get(Ranking.THIRD.getPrize()));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", prizeRankings.get(Ranking.SECOND.getPrize()));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", prizeRankings.get(Ranking.FIRST.getPrize()));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalProfit*100);
    }

    public void printUncheckedLotto (List<List<Integer>> uncheckedLottos) {
        for (List<Integer> lotto: uncheckedLottos) {
            System.out.println(lotto);
        }
    }

    public String inputBonusNumber () {
        System.out.println("보너스 번호를 입력해주세요.");

        return Console.readLine();
    }

    public String inputMoney () {
        System.out.println("구입 금액을 입력해주세요.");

        return Console.readLine();
    }

    public  String inputLottoNumber () {
        System.out.println("당첨 번호를 입력해주세요.");

        return Console.readLine();
    }

    private List<Integer> splitLottoNumber (String tempLottoNumber) {
        List<Integer> lottoNumber = new ArrayList<>();

        for(String element: tempLottoNumber.split(",")) {
            lottoNumber.add(Integer.parseInt(element));
        }

        return lottoNumber;
    }

    private void isRealNumber (String inputStatement) {
        for (char element: inputStatement.toCharArray()) {
            if (element < 49 || element > 57) throw new IllegalArgumentException();
        }
    }

    private void isRealLottoNumber (String lottoNumber) {
        String mergedNumber = String.join(lottoNumber);

        for (char element: mergedNumber.toCharArray()) {
            if (element < 49 || element > 57) throw new IllegalArgumentException();
        }
    }
}
