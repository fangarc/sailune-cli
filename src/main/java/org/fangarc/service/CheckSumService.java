package org.fangarc.service;

import org.fangarc.model.CheckSumResult;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CheckSumService {
    public CheckSumResult calculateHash(File file, String algorithm) throws IOException, NoSuchAlgorithmException {
        byte[] fileContents = Files.readAllBytes(file.toPath());
        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
        String hash = String.format("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));
        return new CheckSumResult(hash);
    }
}
