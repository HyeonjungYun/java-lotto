package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ModelTest {

    @Test
    void 로또_번호_생성_확인() {
        Model model = new Model();
        final List<List<Integer>> lottos = model.repeatGettingLottoNumber(8);

        System.out.println(lottos);
    }

    @Test
    void 로또_비교_확인() {
        Model model = new Model();
        final List<List<Integer>> lottos = List.of(
                List.of(1,4,6,9,15,7),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,7,15),
                List.of(1,2,7,8,9,10),
                List.of(2,3,4,6,5,1),
                List.of(1,2,3,4,5,8),
                List.of(2,3,4,5,6,7)
        );
        final List<Integer>lotto = List.of(1,2,3,4,5,6);
        final int bonusNumber = 7;

        final HashMap<Integer, Integer> result = new HashMap<>();
        result.put(1,2);
        result.put(2,1);
        result.put(3,1);
        result.put(4,1);
        result.put(5,1);

        List<Integer> prizes = model.checkLottoNumber(lotto, lottos);

        assertThat(model.checkPrizeLotto(prizes,lottos, bonusNumber)).isEqualTo(result);
    }

    @Test
    void 수익률_확인() {
        Model model = new Model();
        int money = 6;
        final HashMap<Integer, Integer> prizeRankings = new HashMap<>();
        prizeRankings.put(1,2);
        prizeRankings.put(2,1);
        prizeRankings.put(3,1);
        prizeRankings.put(4,1);
        prizeRankings.put(5,3);

        double result = 671927.5;

        assertThat(model.calculateRateOfProfit(prizeRankings, money)).isEqualTo(result);
    }

    @Test
    void 수익률_확인2() {
        Model model = new Model();
        int money = 6;
        final HashMap<Integer, Integer> prizeRankings = new HashMap<>();
        prizeRankings.put(1,0);
        prizeRankings.put(2,0);
        prizeRankings.put(3,1);
        prizeRankings.put(4,0);
        prizeRankings.put(5,9);

        double result = 257.5;

        assertThat(model.calculateRateOfProfit(prizeRankings, money)).isEqualTo(result);
    }

    @Test
    void 당첨_금액_확인 () {
        Model model = new Model();
        int ranking = 3;
        int number = 4;

        int result = 6_000;

        assertThat(model.profitByRanking(ranking, number)).isEqualTo(result);
    }
}