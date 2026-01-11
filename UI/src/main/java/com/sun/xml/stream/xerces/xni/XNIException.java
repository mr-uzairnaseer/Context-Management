package com.sun.xml.stream.xerces.xni;

/* loaded from: classes5.dex */
public class XNIException extends RuntimeException {
    private Exception fException;

    public XNIException(String str) {
        super(str);
    }

    public Exception getException() {
        return this.fException;
    }

    public XNIException(Exception exc) {
        super(exc.getMessage());
        this.fException = exc;
    }

    public XNIException(String str, Exception exc) {
        super(str);
        this.fException = exc;
    }
}
