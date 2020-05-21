package domain;

public class Player {
    private String name;
    private FrameCollection frames = new FrameCollection();

    public Player(String playerName) {
        this.name = playerName;
    }

    public void bowl(FallingPin pins) throws IllegalAccessException {
        Frame currentFrame = frames.getCurrent();
        currentFrame.fall(pins);
    }

    public FrameCollection getFrames() {
        return frames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|  ").append(name).append("   |").append(frames).append("\n");
        sb.append("         |").append(frames.getScore());

        return sb.toString();
    }

    public boolean hasChance() {
        Frame currentFrame = frames.getCurrent();
        return !currentFrame.isEnd();
    }
}