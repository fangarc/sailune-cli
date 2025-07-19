package org.fangarc.cmd;

import org.fangarc.model.ReadingStatus;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "add",
        description = "Add a new bookmark.",
        mixinStandardHelpOptions = true,
        version = "Sailune 1.0.0"
)
public class AddCommand {
    @Parameters(index = "0", description = "The URL of the bookmark.")
    private String url;

    @Option(names = {"-s", "--status"}, description = "completed, reading, hold, dropped, planned")
    private ReadingStatus status;

    @Option(names = {"-v", "--value"}, description = "The rating of the fiction (1-5).")
    private int rating;
}
