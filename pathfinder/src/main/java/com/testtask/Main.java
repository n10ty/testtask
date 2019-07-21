package com.testtask;

import com.testtask.exception.AppException;
import com.testtask.input.ReaderInterface;
import com.testtask.input.ReaderResolver;
import com.testtask.pathfinder.PathFinderInterface;
import com.testtask.pathfinder.ShortestPathFinder;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        long l = System.nanoTime();
        ReaderResolver resolver = new ReaderResolver();
        ReaderInterface reader = resolver.resolve(args);

        try {
            String mazeStringRepresentation = reader.read();

            MazeBuilder builder = new MazeBuilder();
            Maze maze = builder.build(mazeStringRepresentation);

            PathFinderInterface pathFinder = new ShortestPathFinder();
            Optional<Path> path = maze.findPath(pathFinder);
            if (path.isPresent()) {
                System.out.println(path.get().toString());
            } else {
                System.out.println("No path found");
            }
            System.out.println(System.nanoTime() - l);
        } catch (AppException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
