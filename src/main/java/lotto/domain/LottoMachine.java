package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static LottoMachine instance;

    private Lotto winLotto;

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

    public List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        while (quantity > 0) {
            lottos.add(new Lotto(createLottoNumber()));
            quantity--;
        }

        return lottos;
    }

    private List<Integer> createLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        lottoSort(lottoNumber);

        return lottoNumber;
    }

    private void lottoSort(List<Integer> lottoNumber) {
        Collections.sort(lottoNumber);
    }

    public void setWinLotto(List<Integer> winLotto) {
        this.winLotto = new Lotto(winLotto);
    }
}
