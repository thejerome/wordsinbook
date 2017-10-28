package com.efimchick.wordsinbook;

import java.io.IOException;

/**
 * Created by EE on 2017-10-14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileWordStreamer fileWordStreamer =
            new CombinedFileWordStreamer("WAP12.txt", "WAP34.txt");

        new BookWordCounter(4, 10, fileWordStreamer)
            .printRepeats();
    }
}
