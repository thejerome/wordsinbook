package com.efimchick.wordsinbook;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by EE on 2017-10-14.
 */
public class BookWordCounter {

    private final int minLength;
    private final int minRepeats;
    private final FileWordStreamer fileWordStreamer;

    public BookWordCounter(int minLength, int minRepeats, FileWordStreamer streamer) {
        this.minLength = minLength;
        this.minRepeats = minRepeats;
        fileWordStreamer = streamer;
    }

    public BookWordCounter(FileWordStreamer streamer) {
        this(0, 0, streamer);
    }

    public void printRepeats() throws IOException {

        Map<String, Integer> wordsCount = fileWordStreamer.lines()
            .flatMap(line -> Arrays.stream(line.split("[^a-zA-Zа-яА-Я]")))
            .filter(s -> !s.isEmpty())
            .map(String::toLowerCase)
            .filter(s -> s.length() >= minLength)
            .collect(Collectors.toMap(
                s -> s,
                s -> 1,
                (left, right) -> left + right
            ));

        wordsCount.entrySet().stream()
            .filter(e -> e.getValue() >= minRepeats)
            .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(stringIntegerEntry -> stringIntegerEntry.getValue()).reversed())
            .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

    }

}
