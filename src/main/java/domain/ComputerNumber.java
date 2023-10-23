package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerNumber {
    public static final int LENGTH = 3;
    private List<Integer> computerNumbers = new ArrayList<>();
    private Map<String, Integer> result = new HashMap<>();

    public ComputerNumber(){}

    public void createComputerNumbers() {
        while (computerNumbers.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public Map<String, Integer> countAndGetResult(PlayerNumber playerNumberClass) {
        List<Integer> playerNumbers = playerNumberClass.getPlayerNumberToList();
        int strike = 0;
        int ball = 0;

        for (int i=0;i<computerNumbers.size();i++) {
            if(computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strike++;
            }
        }
        result.put("strike", strike);

        if (strike!=computerNumbers.size()) {
            for (int i=0;i<computerNumbers.size();i++) {
                if(computerNumbers.contains(playerNumbers.get(i))) {
                    ball++;
                }
            }
        }
        result.put("ball", ball - strike);

        if (strike==computerNumbers.size()) {
            playerNumberClass.isWin = true;
        }

        return result;
    }
}
