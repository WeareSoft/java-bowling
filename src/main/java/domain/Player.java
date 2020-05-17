package domain;

public class Player {
    private String name;
    private FrameCollection frames = new FrameCollection();
    private Frame currentFrame = new Frame();

    public Player(String playerName) {
        this.name = playerName;
        frames.add(currentFrame);
    }

    public void bowl(FallingPin pins) throws IllegalAccessException {
        currentFrame = currentFrame();
        currentFrame.fall(pins);
    }

    private Frame currentFrame() {
        if(currentFrame.isEnd()) {
            currentFrame = new Frame(currentFrame);
            frames.add(currentFrame);
            return currentFrame;
        }
        return currentFrame;
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
        return !currentFrame.isEnd();
    }
}