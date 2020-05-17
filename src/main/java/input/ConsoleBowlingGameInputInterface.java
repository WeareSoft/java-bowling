package input;

import domain.FallingPin;

import java.util.Scanner;

public class ConsoleBowlingGameInputInterface implements BowlingGameInputtable {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getPlayerName() {
        System.out.println("이름: ");
        return scanner.nextLine();
    }

    @Override
    public FallingPin getFallingPint() {
        System.out.println("쓰러트린 핀: ");
        return new FallingPin(scanner.nextInt());
    }
}
