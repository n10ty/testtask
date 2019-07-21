package com.testtask;

import com.testtask.exception.MazeBuildException;

public class MazeBuilder {
    public Maze build(String mazeString) throws MazeBuildException {
        String[] rows = mazeString.split("\n");
        Maze maze = new Maze(rows[0].length(), rows.length);

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];

            if (row.length() != maze.getWidth()) {
                throw new MazeBuildException("Maze should be rectangle");
            }
            for (int j=0; j < row.length(); j++) {
                char point = row.charAt(j);
                if (point == '.') {
                    continue;
                }
                if (point == '#') {
                    maze.addBlockedCell(new Cell(j + 1, i + 1));
                    continue;
                }
                if (point == 'S') {
                    maze.addStartCell(new Cell(j + 1, i + 1));
                    continue;
                }
                if (point == 'X') {
                    maze.addFinishCell(new Cell(j + 1, i + 1));
                }
            }
        }
        return maze;
    }
}
