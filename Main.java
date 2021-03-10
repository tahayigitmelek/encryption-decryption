package com.tahayigitmelek;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    static HashMap<String,String> argMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0 ; i<args.length-1; i++){
            argMap.put(args[i],args[i+1]);
        }

        MapSelector mapSelector = new MapSelector(argMap);
        String what = mapSelector.getMap("-mode","enc");
        String alg = mapSelector.getMap("-alg","shift");
        int key = Integer.parseInt(mapSelector.getMap("-key","0"));
        String output = mapSelector.encDec(what, key, alg);


        if (argMap.get("-out")!=null){
            FileWriter writer = new FileWriter(mapSelector.getMap("-out",""));
            writer.write(output);
            writer.close();
        }else{
            System.out.println(output);
        }
    }
}
