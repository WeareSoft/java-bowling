package domain;

import static domain.Frame.FrameStatus.*;

public class Frame implements Scorable {

	public final static int DEFAULT_BOWLING_PIN = 10;

	private FallingPin first = FallingPin.NONE;
	private FallingPin second = FallingPin.NONE;

	public Frame(FallingPin first, FallingPin second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public Score getScore() {
		// some way of calculate score
		return Score.ZERO_SCORE;
	}

	public boolean isEnd() {
		if (first.equals(FallingPin.NONE)) {
			return false;
		}

		return FrameStatus.of(this).equals(STRIKE);
	}

	public enum FrameStatus {
		STRIKE("X"), SPARE("/"), MISS("-"), HIT("");

		String symbol;

		FrameStatus(String symbol) {
			this.symbol = symbol;
		}

		public static FrameStatus of(Frame frame) {
			FallingPin first = frame.first;

			if (first.value() == DEFAULT_BOWLING_PIN) {
				return STRIKE;
			}

			FallingPin second = frame.second;

			if (first.value() + second.value() == DEFAULT_BOWLING_PIN) {
				return SPARE;
			}

			return HIT;
		}
	}

	@Override
	public String toString() {
		switch (FrameStatus.of(this)) {
			case STRIKE:
				return STRIKE.symbol;

			case SPARE:
				return first.getSymbol() + "|" + SPARE.symbol;

			default:
				return first.getSymbol() + "|" + second.getSymbol();
		}
	}
}
