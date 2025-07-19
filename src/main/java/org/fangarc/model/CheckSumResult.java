package org.fangarc.model;

public class CheckSumResult {
    private String hash;

    public CheckSumResult(String hash){
        this.hash = hash;
    }

    public String getHash(){
        return this.hash;
    }
}
