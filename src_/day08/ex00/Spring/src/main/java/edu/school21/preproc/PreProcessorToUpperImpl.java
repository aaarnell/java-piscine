package edu.school21.preproc;

public class PreProcessorToUpperImpl implements PreProcessor {

    public String preProcess(String initString) {
        return initString.toUpperCase();
    }
}
