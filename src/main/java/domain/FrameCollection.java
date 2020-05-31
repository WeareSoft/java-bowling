package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class FrameCollection {
    private LinkedList<Frame> frameList = new LinkedList<>();

    // 현재 유효한 Frame 반환
    public Frame getCurrent() {
        Frame currentFrame;
        if (frameList.isEmpty()) { // 비어있으면 List에 새 Frame 추가 후 반환
            currentFrame = new Frame();
            frameList.add(currentFrame);
            return currentFrame;
        }

        // 비어있지 않지만
        currentFrame = frameList.getLast();
        if (currentFrame.isEnd()) { // 마지막 Frame이 끝났으면 새 Frame 추가 후 반환
            Frame nextFrame = new Frame();
            currentFrame.setNextFrame(nextFrame);
            frameList.add(nextFrame);
            return nextFrame;
        }

        return currentFrame; // 안끝났으면 해당 Frame 반환
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        frameList.stream()
                .map(Frame::toString)
                .forEach(s -> stringBuilder.append(s).append("|"));
        for (int i = 0; i < Frame.DEFAULT_BOWLING_PIN - frameList.size(); i++) {
            stringBuilder.append("       |");
        }

        return stringBuilder.toString();
    }

    public String getScore() {
        StringBuilder stringBuilder = new StringBuilder();
        frameList.stream()
                .map(Frame::getScore)
                .forEach(s -> stringBuilder.append(s).append("   |  "));
        return stringBuilder.toString();
    }
}
