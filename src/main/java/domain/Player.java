package domain;

public class Player {
    private String name;
    private FrameCollection frames = new FrameCollection();
    private Frame currentFrame;

    public Player(String playerName, FrameCollection frameCollection) {
        this.name = playerName;
        this.frames = frameCollection;
    }

    public int bowl(int fallingPinCount) {

        return 0;
    }

    public FrameCollection getFrames() {
        return frames;
    }

    @Override
    public String toString() {
        return "|" + name + "|" + frames;
    }

    public boolean hasChance() {
        return !currentFrame.isEnd();
    }
}