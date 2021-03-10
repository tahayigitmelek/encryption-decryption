package com.tahayigitmelek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class MapSelector {
    private HashMap<String,String> argMap;


    public MapSelector(HashMap<String, String> argMap) {
        this.argMap = argMap;
    }

    public String getMap(String text, String def){
        if (this.argMap.get(text) != null){
            return this.argMap.get(text);
        }else{
            return def;
        }
    }

    public String encDec(String what, int key, String alg) throws IOException {
        WhichMethod decryption = new Decryption();
        WhichMethod encrypt = new Encrypt();
        String output = "";

        if (argMap.get("-data")!=null && argMap.get("-in")==null){
            String dataValue = argMap.get("-data");
            if (what.equals("dec")){
                output = decryption.get(dataValue,key,alg);
            }else {
                output = encrypt.get(dataValue,key,alg);
            }

        }else if (argMap.get("-data")==null && argMap.get("-in")==null){
            output = "";
        }else{
            String dataValue = readFile(argMap.get("-in"));
            if (what.equals("dec")){
                output = decryption.get(dataValue,key,alg);
            }else {
                output = encrypt.get(dataValue,key,alg);
            }
        }
        return output;
    }

    public String readFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}
