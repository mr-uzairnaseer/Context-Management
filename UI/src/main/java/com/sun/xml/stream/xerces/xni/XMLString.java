package com.sun.xml.stream.xerces.xni;

/* loaded from: classes5.dex */
public class XMLString {
    public char[] ch;
    public int length;
    public int offset;

    public XMLString() {
    }

    public void clear() {
        this.ch = null;
        this.offset = 0;
        this.length = -1;
    }

    public boolean equals(char[] cArr, int i3, int i4) {
        if (cArr == null || this.length != i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.ch[this.offset + i5] != cArr[i3 + i5]) {
                return false;
            }
        }
        return true;
    }

    public void setValues(char[] cArr, int i3, int i4) {
        this.ch = cArr;
        this.offset = i3;
        this.length = i4;
    }

    public String toString() {
        int i3 = this.length;
        return i3 > 0 ? new String(this.ch, this.offset, i3) : "";
    }

    public XMLString(char[] cArr, int i3, int i4) {
        setValues(cArr, i3, i4);
    }

    public boolean equals(String str) {
        if (str == null || this.length != str.length()) {
            return false;
        }
        for (int i3 = 0; i3 < this.length; i3++) {
            if (this.ch[this.offset + i3] != str.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    public XMLString(XMLString xMLString) {
        setValues(xMLString);
    }

    public void setValues(XMLString xMLString) {
        setValues(xMLString.ch, xMLString.offset, xMLString.length);
    }
}
