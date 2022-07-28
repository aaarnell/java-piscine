package edu.school21.renderer;


import edu.school21.preproc.PreProcessor;

public class RendererStandardImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    public void print(String message) {
        message = preProcessor.preProcess(message);
        System.out.println(message);
    }
}
