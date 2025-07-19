package org.fangarc.cmd;

import org.fangarc.service.CheckSumService;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "checksum", description = "Prints the checksum of a file to STDOUT", mixinStandardHelpOptions = true, version = "checksum 4.0")
public class CheckSum implements Callable<Integer> {
    @Parameters(index = "0", description = "The file whose checksum to calculate.")
    private File file;

    @Option(names = {"-a", "--algorithm"}, description = "MD5, SHA-1, SHA-256, ....")
    private String algorithm;

    private CheckSumService checkSumService;

    public CheckSum() {
        this.checkSumService = new CheckSumService();
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(checkSumService.calculateHash(file, algorithm).getHash());
        return 0;
    }
}
