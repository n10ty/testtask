package test.com.testtask;

import com.testtask.Direction;
import com.testtask.Path;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PathTest {
    @Test()
    public void addDirectionsToPath() {
        Path path = Path.empty();
        path = path.addDirection(Direction.RIGHT);
        path = path.addDirection(Direction.LEFT);
        path = path.addDirection(Direction.DOWN);
        path = path.addDirection(Direction.UP);

        assertEquals("r,l,d,u", path.toString());
    }
}
