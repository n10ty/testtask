package com.testtask;

import java.util.Objects;

public class Cell {
    public final int x;
    public final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;

        return x == cell.x && y == cell.y;
    }

    @Override
    public String toString() {
        return x + ";" + y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}