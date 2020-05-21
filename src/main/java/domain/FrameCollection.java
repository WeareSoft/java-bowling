package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class FrameCollection {
    private LinkedList<Frame> frameList = new LinkedList<>();

    public Frame getCurrent() {
        if(frameList.isEmpty()) {
            frameList.add(Frame.NONE_FRAME);
        }

        Frame currentFrame = frameList.getLast();
        if (currentFrame.isEnd()) {
            currentFrame = new Frame(currentFrame);
        }
        return currentFrame;
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

    public static void main(String[] args) {
        LinkedList<Frame> frameList = new LinkedList<>();

        System.out.println(Optional.of(frameList.getLast()).orElse(Frame.NONE_FRAME));
    }
}
