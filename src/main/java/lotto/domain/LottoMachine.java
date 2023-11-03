package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.LottoPrize;

public class LottoMachine {
    private static LottoMachine instance;

    private WinLotto winLotto;

    private LottoMachine() {
    }

    public static LottoMachine getInstance() {
        if (instance == null) {
            synchronized (LottoMachine.class) {
                instance = new LottoMachine();
            }
        }
        return instance;
    }

    public void setWinLotto(WinLotto winLotto) {
        this.winLotto = winLotto;
    }

    /**
     * 입력 갯수 만큼 로또 번호 생성
     *
     * @param quantity
     * @return
     */
    public List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        while (quantity > 0) {
            lottos.add(new Lotto(createLottoNumber()));
            quantity--;
        }

        return lottos;
    }

    /**
     * 자동 로또 번호 생성
     *
     * @return
     */
    private List<Integer> createLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return lottoSort(lottoNumber);
    }

    /**
     * 로또 번호 오름 차순 정렬
     *
     * @param lottoNumber
     */
    private List<Integer> lottoSort(List<Integer> lottoNumber) {
        List<Integer> sortedLottoNumber = new ArrayList<>(lottoNumber);

        Collections.sort(sortedLottoNumber); // 오름차순 정렬
        
        return sortedLottoNumber;
    }

    /**
     * 로또 당첨 확인
     *
     * @param otherLotto
     * @return int
     */
    public LottoPrize lottoWinningResult(Lotto otherLotto) {
        return winLotto.lottoComparison(otherLotto);
    }
}
