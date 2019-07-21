package com.testtask.pathfinder;

import com.testtask.Maze;
import com.testtask.Path;

import java.util.Optional;

public interface PathFinderInterface {
    Optional<Path> findPath(Maze maze);
}
