package com.testtask.pathfinder;

import com.testtask.Direction;
import com.testtask.Maze;
import com.testtask.Path;
import com.testtask.Cell;

import java.util.*;

/**
 * This pathfinder use Lee algorithm to find shortest path between two points.
 * https://en.wikipedia.org/wiki/Lee_algorithm
 */
public class ShortestPathFinder implements PathFinderInterface {
    public Optional<Path> findPath(Maze maze) {

        HashSet<Cell> visited = new HashSet<>();
        HashMap<Cell, Path> paths = new HashMap<>();

        Queue<Cell> cellProcessor = new LinkedList<>();

        Cell start = maze.getStartCell();
        Cell finish = maze.getFinishCell();

        int width = maze.getWidth();
        int height = maze.getHeight();

        cellProcessor.add(start);
        visited.add(start);
        paths.put(start, Path.empty());

        while (!cellProcessor.isEmpty()) {
            Cell current = cellProcessor.poll();

            Path pathToCurrentPoint = paths.get(current);

            if (current.equals(finish)) {
                return Optional.of(pathToCurrentPoint);
            }

            // current point has neighboring point on the left
            if (current.x > 1) {
                Cell leftCell = new Cell(current.x - 1, current.y);
                if (!visited.contains(leftCell) && !maze.isBlocked(leftCell)) {
                    cellProcessor.add(leftCell);
                    Path newPath = (Path) pathToCurrentPoint.clone();
                    paths.put(leftCell, newPath.addDirection(Direction.LEFT));
                    visited.add(leftCell);
                }
            }

            // current point has neighboring point on the right
            if (current.x < width) {
                Cell rightCell = new Cell(current.x + 1, current.y);
                if (!visited.contains(rightCell) && !maze.isBlocked(rightCell)) {
                    cellProcessor.add(rightCell);
                    Path newPath = (Path) pathToCurrentPoint.clone();
                    paths.put(rightCell, newPath.addDirection(Direction.RIGHT));
                    visited.add(rightCell);
                }
            }

            // current point has neighboring point above
            if (current.y > 1) {
                Cell aboveCell = new Cell(current.x, current.y - 1);
                if (!visited.contains(aboveCell) && !maze.isBlocked(aboveCell)) {
                    cellProcessor.add(aboveCell);
                    Path newPath = (Path) pathToCurrentPoint.clone();
                    paths.put(aboveCell, newPath.addDirection(Direction.UP));
                    visited.add(aboveCell);
                }
            }

            // current point has neighboring point below
            if (current.y < height) {
                Cell belowCell = new Cell(current.x, current.y + 1);
                if (!visited.contains(belowCell) && !maze.isBlocked(belowCell)) {
                    cellProcessor.add(belowCell);
                    Path newPath = (Path) pathToCurrentPoint.clone();
                    paths.put(belowCell, newPath.addDirection(Direction.DOWN));
                    visited.add(belowCell);
                }
            }
        }

        return Optional.empty();
    }
}
