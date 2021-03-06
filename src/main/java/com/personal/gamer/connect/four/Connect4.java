package com.personal.gamer.connect.four;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Connect4 {

    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final String EMPTY = "";

    private String[][] board = new String[ROWS][COLUMNS];

    public Connect4() {
        for (String[] row : board) {
            Arrays.fill(row, EMPTY);
        }
    }

    public int getNumberOfDiscs() {
        return IntStream.range(0, COLUMNS)
                .map(this::getNumberOfDiscsInColumn)
                .sum();
    }

    public int putDiscInColumn(int column) {
        checkColumn(column);
        int row = getNumberOfDiscsInColumn(column);
        checkPositionToInsert(row, column);
        board[row][column] = "X";

        return row;
    }

    private int getNumberOfDiscsInColumn(final int column) {
        return (int) IntStream.range(0, ROWS)
                .filter(row -> !EMPTY.equals(board[row][column]))
                .count();
    }

    private void checkColumn(final int column) {
        if (column < 0 || column >= COLUMNS) {
            throw new RuntimeException("Invalid column " + column);
        }
    }

    private void checkPositionToInsert(final int row, final int column) {
        if (row == ROWS) {
            throw new RuntimeException("No more room in column " + column);
        }
    }
}
