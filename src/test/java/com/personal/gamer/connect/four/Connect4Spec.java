package com.personal.gamer.connect.four;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class Connect4Spec {
    private Connect4 tested;

    @Before
    public void beforeEachTest() {
        tested = new Connect4();
    }

    @Test
    public void whenTheGameIsStarteddTheBoardIsEmpty() {
        assertThat(tested.getNumberOfDiscs(), is(0));
    }

    @Test
    public void whenDiscOutSideBoardThenRuntimeException() {
        int column = -1;

        RuntimeException exception = assertThrows(RuntimeException.class, () -> tested.putDiscInColumn(column));

        assertEquals("Invalid column " + column, exception.getMessage());
    }

    @Test
    public void whenFirstDiscInsertedInColumnThenPositionIsZero() {
        int column = 1;

        assertThat(tested.putDiscInColumn(column), is(0));
    }

    @Test
    public void whenSecondDiscInsertedInColumnThenPositionIsOne() {
        int column = 1;

        tested.putDiscInColumn(column);
        assertThat(tested.putDiscInColumn(column), is(1));
    }

    @Test
    public void whenDiscInsertedThenNumberOfDiscsIncrease() {
        int column = 1;

        tested.putDiscInColumn(column);
        assertThat(tested.getNumberOfDiscs(), is(1));
    }

    @Test
    public void whenNoMoreRoomInColumnTheRuntimeException() {
        int column = 1;
        int maxDiscInColumn = 6;

        for (int times = 0; times < maxDiscInColumn; ++times) {
            tested.putDiscInColumn(column);
        }

        RuntimeException exception = assertThrows(RuntimeException.class, () -> tested.putDiscInColumn(column));

        assertEquals("No more room in column " + column, exception.getMessage());
    }
}