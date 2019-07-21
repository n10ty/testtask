package com.testtask.input;

import java.util.Scanner;

public class StdInReader implements ReaderInterface {
    @Override
    public String read() {
        Scanner scn = new Scanner(System.in);

        String input;
        String mazeStringRepresentation = "";
        while (scn.hasNextLine()) {
            input = scn.nextLine();
            mazeStringRepresentation = mazeStringRepresentation.concat(input + "\n");
        }

        return mazeStringRepresentation;
    }
}
