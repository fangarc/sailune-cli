package org.fangarc;

import org.fangarc.cmd.CheckSum;
import picocli.CommandLine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] dummyArgs = {"/home/satyaand/Projects/sailune-cli/README.md", "-a", "MD5"};
        int exitCode = new CommandLine(new CheckSum()).execute(dummyArgs);
        System.exit(exitCode);
    }
}