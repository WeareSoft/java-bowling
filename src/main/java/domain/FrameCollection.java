package domain;

import output.BollingScorePresentable;

import java.util.ArrayList;
import java.util.List;

public class FrameCollection {
    private List<Frame> frameList = new ArrayList<>();

    public void add(Frame frame) {
        frameList.add(frame);
    }

    public void printScore(BollingScorePresentable printer) {

    }
}
