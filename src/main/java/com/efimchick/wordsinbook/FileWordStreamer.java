package com.efimchick.wordsinbook;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by EE on 2017-10-14.
 */
public class FileWordStreamer {

    private final String filePath;
    final Charset cs;

    public FileWordStreamer(String filePath, Charset cs) {
        this.filePath = filePath;
        this.cs = cs;
    }

    public FileWordStreamer(String filePath) {
        this(filePath, Charset.forName("windows-1251"));
    }

    Stream<String> lines() {
        Path bookPath = Paths.get(filePath);
        try {
            return Files.lines(bookPath, cs);
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }
}
