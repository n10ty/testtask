package com.testtask;

public class Path {
    private String path;

    private Path(String path) {
        this.path = path;
    }

    private Path() {
        path = "";
    }

    public static Path empty() {
        return new Path();
    }

    public Path addDirection(Direction direction) {
        if (!path.equals("")) {
            path += ",";
        }
        path += direction.name().substring(0, 1).toLowerCase();

        return this;
    }

    @Override
    public String toString() {
        return path;
    }

    @Override
    public Object clone() {
        return new Path(path);
    }
}
