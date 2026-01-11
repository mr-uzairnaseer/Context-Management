package com.sun.xml.stream;

import java.io.PrintStream;

/* loaded from: classes5.dex */
public class Version {
    public static void main(String[] strArr) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Sun Java Streaming XML Parser Version is '");
        stringBuffer.append(Package.getPackage("com.sun.xml.stream").getImplementationVersion());
        stringBuffer.append("'");
        printStream.println(stringBuffer.toString());
    }
}
