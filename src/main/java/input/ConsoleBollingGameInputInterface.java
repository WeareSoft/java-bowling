package input;

import java.util.Scanner;

public class ConsoleBollingGameInputInterface implements BollingGameInputtable {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getPlayerName() {
        System.out.println("이름: ");
        return scanner.nextLine();
    }

    @Override
    public int getFallingPint() {
        System.out.println("쓰러트린 핀: ");
        return scanner.nextInt();
    }
}
