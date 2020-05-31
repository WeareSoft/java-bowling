package domain;

import java.util.List;

public class Players {
	private List<Player> players;
	private int currentPlayerIndex;

	public Players(List<Player> players) {
		this.players = players;
	}

	public Player getCurrentPlayer() {
		Player currentPlayer = currentPlayer();
		if (currentPlayer.hasChance()) {
			return currentPlayer;
		}

		return nextPlayer();
	}

	private Player nextPlayer() {
		currentPlayerIndex = currentPlayerIndex % players.size();
		return players.get(currentPlayerIndex++);
	}

	public boolean isLastPlayer() {
		return currentPlayerIndex == players.size();
	}

	private Player currentPlayer() {
		return players.get(currentPlayerIndex);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		players.stream().map(Player::toString).forEach(stringBuilder::append);
		return stringBuilder.toString();
	}
}
