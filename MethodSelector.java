package com.tahayigitmelek;

public class MethodSelector {
    private WhichMethod method;

    public void setMethod(WhichMethod method){
        this.method = method;
    }

    public void select(String text, int num, String alg){
        this.method.get(text,num,alg);
    }
}
