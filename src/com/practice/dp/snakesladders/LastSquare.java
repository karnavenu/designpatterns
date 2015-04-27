package com.practice.dp.snakesladders;

public class LastSquare extends Square {

	public LastSquare(Game game, int position) {
		super(game, position);
	}

	@Override
	public boolean isLastSquare() {
		return true;
	}
}
