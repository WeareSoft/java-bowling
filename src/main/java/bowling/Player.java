package bowling;

public class Player {
	private final String name;

	private static final int MAX_LENGTH = 3;

	public static Player of(final String name) {
		return new Player(name);
	}

	private Player(final String name) {
		if (name.length() > MAX_LENGTH )
			throw new IllegalArgumentException("3글자까지 가능");
		this.name = name;
	}

    public String getPlayerName() {
        return name;
    }
}
