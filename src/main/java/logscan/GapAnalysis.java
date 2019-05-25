package logscan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class GapAnalysis {

    static void process() {

    }
    public static void main (String args[]) throws IOException {

        String logfile = "/Users/issmith1/workspace/intellij-algos/src/main/resources/sqs.log_051522_20";
        try (Stream<String> stream = Files.lines(Paths.get(logfile))) {
            stream.forEach(System.out::println);
            process();
        }
    }
}
