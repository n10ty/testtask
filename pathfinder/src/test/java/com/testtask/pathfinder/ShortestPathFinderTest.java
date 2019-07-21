package test.com.testtask.pathfinder;

import com.testtask.Maze;
import com.testtask.MazeBuilder;
import com.testtask.Path;
import com.testtask.exception.AppException;
import com.testtask.input.FileReader;
import com.testtask.pathfinder.ShortestPathFinder;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ShortestPathFinderTest {

    @Test
    public void verfiyResultShortestPath() throws AppException {

        FileReader reader = new FileReader(Paths.get("src/test/java/com/testtask/pathfinder/maze.txt").toString());
        String m = reader.read();
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.build(m);

        Optional<Path> path = maze.findPath(new ShortestPathFinder());

        assertEquals("r,r,r,d,d,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,d,d,d,d,d,d,d,d", path.get().toString());
    }

    @Test
    public void verfiyResultShortestPathWithOneCorrectPath() throws AppException {

        FileReader reader = new FileReader(Paths.get("src/test/java/com/testtask/pathfinder/mazewithonepath.txt").toString());
        String m = reader.read();
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.build(m);

        Optional<Path> path = maze.findPath(new ShortestPathFinder());

        assertEquals("l,l,d,d,r,r,r,r,r,u,u,u,r,r,r,r,r,d,d,d,d,d,l,l,l,l,l,l,l,l,l,l", path.get().toString());
    }

    @Test
    public void verfiyResultShortestPathWithNoPath() throws AppException {

        FileReader reader = new FileReader(Paths.get("src/test/java/com/testtask/pathfinder/mazenopath.txt").toString());
        String m = reader.read();
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.build(m);

        Optional<Path> path = maze.findPath(new ShortestPathFinder());

        assertFalse(path.isPresent());
    }
}
