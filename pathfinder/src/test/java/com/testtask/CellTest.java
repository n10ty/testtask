package test.com.testtask;

import com.testtask.Cell;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test()
    public void equalsWithEqualCellsShouldReturnTrue() {
        Cell cell1 = new Cell(1, 2);
        Cell cell2 = new Cell(1, 2);
        assertEquals(cell1, cell2);
    }

    @Test()
    public void equalsWithNotEqualCellsShouldReturnFalse() {
        Cell cell1 = new Cell(2, 2);
        Cell cell2 = new Cell(1, 2);
        assertNotEquals(cell1, cell2);
    }
}