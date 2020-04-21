package output;

import static bowling.frame.FrameNo.FINAL_FRAME_NO;

import bowling.frame.Frame;
import bowling.score.FrameScore;
import bowling.score.UnitScore;
import java.util.stream.Collectors;
import user.User;

public class BowlingCommandMode {

    private static final String SPLITTER = "|";
    private static final String NAME_FORMAT = SPLITTER + " %5s " + SPLITTER;
    private static final String APPEND_FORMAT = " %5s " + SPLITTER;

    public static String getString(String displayName) {
        System.out.print(displayName);

        System.out.println();

//        Scanner scanner = new Scanner(System.in);
//        return scanner.next();

        return "KYJ";
    }

    public static Integer getInteger(String displayName) {
        System.out.print(displayName);
        System.out.println();

//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextInt();

        return 5;
    }

    public static void printTable(User user, Frame frame) {
        printTableHeader();
        printTableValue(user, frame);
    }

    private static void printTableHeader() {
        printName("NAME");
        printFrameHeader();
        System.out.println();
    }

    private static void printTableValue(User user, Frame frame) {
        printName(user.getName());
        printFrameValue(frame);
    }

    private static void printName(String name) {
        System.out.print(String.format(NAME_FORMAT, name));
    }

    private static void printFrameHeader() {
        for (int i = 1; i <= FINAL_FRAME_NO; i++) {
            String formatNumber = String.format(APPEND_FORMAT, String.format("%02d", i));
            System.out.print(formatNumber);
        }
    }

    private static void printFrameValue(Frame frame) {
        for (int i = 1; i <= FINAL_FRAME_NO; i++) {
            String scoreString = "";
            if (frame != null) {
                scoreString = buildScoreDisplay(frame.getScore());
            }
            String formatNumber = String.format(APPEND_FORMAT, String.format("%2s", scoreString));
            System.out.print(formatNumber);

            if (frame != null) {
                frame = frame.getNextFrame();
            }
        }
        System.out.println();
    }

    private static String buildScoreDisplay(FrameScore score) {
        String scoreInfo = score.getScores().stream()
                .map(UnitScore::getScore)
                .map(String::valueOf)
                .collect(Collectors.joining(SPLITTER));

        switch (score.getScoreType()) {
            case Strike:
                return "X";
            case Spare:
                return score.getScores().get(0).getScore() + SPLITTER + "/";
            case Gutter:
                return score.getScores().get(0).getScore() + SPLITTER + "-";
            default:
                return scoreInfo;
        }
    }
}
