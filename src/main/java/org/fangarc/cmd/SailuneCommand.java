package org.fangarc.cmd;

import picocli.CommandLine.Command;

@Command(
        name = "sailune",
        mixinStandardHelpOptions = true,
        version = "Sailune 1.0.0",
        description = "CLI Fanfiction Bookmark Manager",
        subcommands = {
            ListCommand.class,
            DeleteCommand.class,
            UpdateCommand.class,
        }
)
public class SailuneCommand implements Runnable {
    @Override
    public void run(){}
}
