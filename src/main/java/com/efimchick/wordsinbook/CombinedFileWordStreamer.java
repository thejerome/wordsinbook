package com.efimchick.wordsinbook;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by EE on 2017-10-14.
 */
public class CombinedFileWordStreamer extends FileWordStreamer {


    private final String[] filePaths;

    public CombinedFileWordStreamer(Charset cs, String... filePaths) {
        super(null, cs);
        this.filePaths = filePaths;
    }

    public CombinedFileWordStreamer(String... filePaths) {
        super(null);
        this.filePaths = filePaths;
    }

    Stream<String> lines() {
        return Arrays.stream(filePaths)
            .map(path -> new FileWordStreamer(path, super.cs))
            .flatMap(streamer -> streamer.lines());
    }
}
