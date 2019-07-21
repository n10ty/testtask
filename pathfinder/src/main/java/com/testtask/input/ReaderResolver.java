package com.testtask.input;

public class ReaderResolver {

    public ReaderInterface resolve(String[] args) {
        if (args.length > 0) {
            return new FileReader(args[0]);
        }

        return new StdInReader();
    }
}
