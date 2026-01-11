package com.sun.xml.stream.xerces.xni;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class QName implements Cloneable {
    public char[] characters = null;
    public String localpart;
    public String prefix;
    public String rawname;
    public String uri;

    public QName() {
        clear();
    }

    public void clear() {
        this.prefix = null;
        this.localpart = null;
        this.rawname = null;
        this.uri = null;
    }

    public Object clone() {
        return new QName(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof QName) {
            QName qName = (QName) obj;
            String str = qName.uri;
            if (str != null) {
                return this.uri == str && this.localpart == qName.localpart;
            }
            if (this.uri == null && this.rawname == qName.rawname) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.uri;
        return str != null ? str.hashCode() + this.localpart.hashCode() : this.rawname.hashCode();
    }

    public void setValues(QName qName) {
        this.prefix = qName.prefix;
        this.localpart = qName.localpart;
        this.rawname = qName.rawname;
        this.uri = qName.uri;
        this.characters = qName.characters;
    }

    public String toString() {
        boolean z2;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z3 = true;
        if (this.prefix != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("prefix=\"");
            stringBuffer2.append(this.prefix);
            stringBuffer2.append('\"');
            stringBuffer.append(stringBuffer2.toString());
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.localpart != null) {
            if (z2) {
                stringBuffer.append(AbstractJsonLexerKt.COMMA);
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("localpart=\"");
            stringBuffer3.append(this.localpart);
            stringBuffer3.append('\"');
            stringBuffer.append(stringBuffer3.toString());
            z2 = true;
        }
        if (this.rawname != null) {
            if (z2) {
                stringBuffer.append(AbstractJsonLexerKt.COMMA);
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("rawname=\"");
            stringBuffer4.append(this.rawname);
            stringBuffer4.append('\"');
            stringBuffer.append(stringBuffer4.toString());
        } else {
            z3 = z2;
        }
        if (this.uri != null) {
            if (z3) {
                stringBuffer.append(AbstractJsonLexerKt.COMMA);
            }
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("uri=\"");
            stringBuffer5.append(this.uri);
            stringBuffer5.append('\"');
            stringBuffer.append(stringBuffer5.toString());
        }
        return stringBuffer.toString();
    }

    public QName(String str, String str2, String str3, String str4) {
        setValues(str, str2, str3, str4);
    }

    public void setValues(String str, String str2, String str3, String str4) {
        this.prefix = str;
        this.localpart = str2;
        this.rawname = str3;
        this.uri = str4;
    }

    public QName(QName qName) {
        setValues(qName);
    }
}
