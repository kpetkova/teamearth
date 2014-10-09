package com.softuni.earth.base;

import com.softuni.earth.utils.Constants;

public class GameField {

	private GameObject[][] gameField;

	private int fieldCols;

	private int fieldRows;

	public GameField() {
		initGameField();
	}

	public GameField(int rows, int cols) {
		// This will call the default constructor.
		this();
		fieldRows = rows;
		fieldCols = cols;
	}

	private void initGameField() {
		boolean shouldUseDefaultValues = fieldCols == 0 || fieldRows == 0;
		if (shouldUseDefaultValues) {
			fieldRows = Constants.DEFAULT_FIELD_ROWS;
			fieldCols = Constants.DEFAULT_FIELD_COLS;
		}
		gameField = new GameObject[fieldRows][fieldCols];
		setupField();
	}

	public void runGame() {
		for (int i = 0; i < fieldCols; i++) {
			for (int k = 0; k < fieldRows; k++) {
				System.out.print(k + ": " + gameField[i][k] + " ");
			}
			System.out.println();
		}
	}

	// TODO: Random items,bonuses, creatures on startup?
	private void setupField() {

	}
}
