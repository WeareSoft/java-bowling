package domain;

import java.util.ArrayList;
import java.util.List;

public class FrameCollection {
    private List<Frame> frameList = new ArrayList<>();

    public void add(Frame frame) {
        frameList.add(frame);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        frameList.stream()
                .map(Frame::toString)
                .forEach(s -> stringBuilder.append(s).append("  |  "));

        return stringBuilder.toString();
    }

    public String getScore() {
        StringBuilder stringBuilder = new StringBuilder();
        frameList.stream()
                .map(Frame::getScore)
                .forEach(s -> stringBuilder.append(s).append("   |   "));

        return stringBuilder.toString();
    }
}
