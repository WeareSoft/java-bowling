package output;

import domain.BowlingGame;

public class ConsoleBowlingScorePresenter implements BowlingScorePresentable {

    private final static String STRIKE_SYMBOL = "X";
    private final static String SPARE_SYMBOL = "/";
    private final static String MISS_SYMBOL = "-";

    public static void print(BowlingGame bowlingGame) {

    }

    /*@Override
    public void show(final List<Player> players) {
        // print about player info (score)
    }

    @Override
    public void show(Player player) {

    }

    @Override
    public void show(Frame frame) {
        StringBuilder stringBuilder = new StringBuilder();


        switch (Frame.FrameStatus.of(frame)) {
            case STRIKE:
                break;
        }


        System.out.println(stringBuilder);
    }

    @Override
    public void show(FallingPin fallingPin) {

    }

    public static void main(String[] args) {
        String s = "5|/";
        String s1 = "X";
        // String s2 = "5|/";
        System.out.print("|");

        System.out.print(String.format("%-6s|%-6s|%-6s", s, s1, s));
        System.out.print("|");
    }*/
}
