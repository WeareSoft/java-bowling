package bowling.score;

public class Score {
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 10;
	public static final Score ZERO = Score.of(MIN_VALUE);
	public static final Score TEN = Score.of(MAX_VALUE);

	private final int value;

	public static Score of(final int value) {
		return new Score(value);
	}

	private Score(final int value) {
		if (value < MIN_VALUE || value > MAX_VALUE)
			throw new IllegalArgumentException("점수는 0이상 10이하");
		this.value = value;
	}

	public Score add(final Score score) {
		return Score.of(this.value + score.toInt());
	}

	public boolean isZero() {
		return this.equals(Score.ZERO);
	}

	public boolean isTen() {
		return this.equals(Score.TEN);
	}

	private int toInt() {
		return this.value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Score)) return false;
		Score score = (Score) o;
		return value == score.value;
	}

	@Override
	public int hashCode() {
		return value;
	}
}
