package edu.school21.renderer;

import edu.school21.preproc.PreProcessor;

public class RendererErrImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    public void print(String message) {
        message = preProcessor.preProcess(message);
        System.err.println(message);
    }
}
