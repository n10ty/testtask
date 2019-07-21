package com.testtask;


import com.testtask.pathfinder.PathFinderInterface;

import java.util.HashSet;
import java.util.Optional;

public class Maze {
    private int width;
    private int height;
    private Cell start;
    private Cell finish;
    private HashSet<Cell> blocked;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;

        blocked = new HashSet<>();
    }

    public void addBlockedCell(Cell point) {
        blocked.add(point);
    }

    public void addStartCell(Cell point) {
        start = point;
    }

    public Cell getStartCell() {
        return start;
    }

    public void addFinishCell(Cell point){
        finish = point;
    }

    public Cell getFinishCell() {
        return finish;
    }

    public boolean isBlocked(Cell point) {
        return blocked.contains(point);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Optional<Path> findPath(PathFinderInterface pathFinder) {
        return pathFinder.findPath(this);
    }
}


