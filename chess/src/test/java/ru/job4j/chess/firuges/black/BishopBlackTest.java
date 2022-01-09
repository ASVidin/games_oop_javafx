package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void whenPositionF8() {
        Figure bishop = new BishopBlack(Cell.F8);
        Cell actual = bishop.position();
        Cell expected = Cell.F8;
        assertThat(actual, is(expected));
    }

    @Test
    public void whenCopyFromC8ToE6() {
        Figure bishop = new BishopBlack(Cell.C8).copy(Cell.E6);
        Cell actual = bishop.position();
        Cell expected = Cell.E6;
        assertThat(actual, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenIncorrectMove() {
        Figure bishop = new BishopBlack(Cell.C1);
        bishop.way(Cell.F5);
    }

    @Test()
    public void whenWayFromC1ToG5() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] actual = bishop.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, actual);
    }
}