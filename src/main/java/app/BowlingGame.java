package app;

import static bowling.frame.FrameNo.START_FRAME_NO;

import bowling.NormalThrowStrategy;
import bowling.frame.Frame;
import output.BowlingCommandMode;
import user.User;

public class BowlingGame {

    public static void main(String[] args) {
        String name = BowlingCommandMode.getString("플레이어 이름은(3 english letters)?: ");

        User user = new User(name);
        Frame frame = new Frame(START_FRAME_NO, new NormalThrowStrategy());
        Frame currentFrame = frame;
        BowlingCommandMode.printTable(user, frame);

        while (!currentFrame.isComplete()) {
            int droppedPins = BowlingCommandMode.getInteger(String.format("%d프레임 투구 : ", currentFrame.getFrameNo()));
            currentFrame.throwBowling(droppedPins);
            BowlingCommandMode.printTable(user, frame);

            if (currentFrame.getNextFrame() != null) {
                currentFrame = currentFrame.getNextFrame();
            }
        }
    }
}
