package com.testtask.input;

import com.testtask.exception.ReadException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader implements ReaderInterface {
    private final String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String read() throws ReadException {
        File f = new File(filePath);
        if(f.exists() && !f.isDirectory()) {
            byte[] encoded;
            try {
                encoded = Files.readAllBytes(Paths.get(filePath));
            } catch (IOException e) {
                throw new ReadException("Error read from file");
            }

            return new String(encoded);
        }

        throw new ReadException("File not exists: " + filePath);
    }
}
