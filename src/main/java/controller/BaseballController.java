package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.ComputerNumber;
import domain.PlayerNumber;
import view.InputView;
import view.OutputView;

public class BaseballController {
    ComputerNumber computerNumber = new ComputerNumber();
    PlayerNumber playerNumber = new PlayerNumber();

    public void gameStart() {
        OutputView.printGameStartMessage();
        computerNumber.createComputerNumbers();
        round();
        OutputView.printWinMessage();
    }

    private void round() {
        do {
            playerNumber.setPlayerNumbers(InputView.inputPlayerNumbers());
            OutputView.printResult(computerNumber.countAndGetResult(playerNumber));
        } while(!playerNumber.isWin);
    }

}
