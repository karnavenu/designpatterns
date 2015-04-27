package com.practice.dp.snakesladders;

public class Snake extends Ladder {

	public Snake(int transport, Game game, int position) {
		super(transport, game, position);
	}

	@Override
	protected String squareLabel() {
		return this.destination().position() + "<-" + position;
	}

}
