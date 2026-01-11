package com.sun.xml.stream.xerces.xni;

import java.util.Enumeration;

/* loaded from: classes5.dex */
public interface Augmentations {
    Object getItem(String str);

    Enumeration keys();

    Object putItem(String str, Object obj);

    void removeAllItems();

    Object removeItem(String str);
}
