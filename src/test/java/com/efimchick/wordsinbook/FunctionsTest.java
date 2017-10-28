package com.efimchick.wordsinbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by EE on 2017-10-14.
 */
public class FunctionsTest {

    @Test
    public void fileMayBeFound() throws IOException {
        Stream<String> lines = new FileWordStreamer("lorem.txt").lines();
        Assert.assertEquals(1, lines.count());
    }
    @Test
    public void linesCountIsCorrect() throws IOException {
        Stream<String> lines = new FileWordStreamer("WAP12.txt").lines();
        Assert.assertEquals(6702, lines.count());
    }
}
