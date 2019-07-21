package com.testtask;

import com.testtask.exception.MazeBuildException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeBuilderTest {
    @Test
    public void buildMazeFromStringReturnMaze() throws MazeBuildException {
        String stringMaze =
                "....................................\n" +
                "..S...#......................#......\n" +
                "......#......................#......\n" +
                ".............................#......\n" +
                "....................................\n" +
                "....................................\n" +
                "..............#.....................\n" +
                "............#.......................\n" +
                "..........#.........................\n" +
                "....................................\n" +
                ".....................#..........#...\n" +
                ".....................#....X.....#...\n" +
                ".....................#..........#...\n" +
                "....................................";
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.build(stringMaze);

        assertEquals(14, maze.getHeight());
        assertEquals(36, maze.getWidth());

        assertEquals(new Cell(3, 2), maze.getStartCell());
        assertEquals(new Cell(27, 12), maze.getFinishCell());
        assertTrue(maze.isBlocked(new Cell(7, 2)));
    }
}
