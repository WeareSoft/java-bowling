package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Frame> frames = new ArrayList<>();

    public Player(String playerName) {

        this.name = playerName;
    }

    public int bowl(int fallingPinCount) {
        Frame currentFrame = getCurrentFrame();
        return 1;
        //return currentFrame.bowl(fallingPinCount);
    }

    private Frame getCurrentFrame() {
        int lastFrameIndex = frames.size() - 1;
        return frames.get(lastFrameIndex);
    }

    public boolean isEnd() {
        return false;
    }
}