package com.sun.xml.stream.xerces.util;

import java.util.Locale;
import java.util.MissingResourceException;

/* loaded from: classes5.dex */
public interface MessageFormatter {
    String formatMessage(Locale locale, String str, Object[] objArr) throws MissingResourceException;
}
