package kotlin.reflect.jvm.internal.impl.name;

import de.komoot.android.services.api.JsonKeywords;

/* loaded from: classes2.dex */
public final class Name implements Comparable<Name> {

    /* renamed from: a, reason: collision with root package name */
    public final String f154659a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f154660b;

    public Name(String str, boolean z2) {
        if (str == null) {
            a(0);
        }
        this.f154659a = str;
        this.f154660b = z2;
    }

    public static /* synthetic */ void a(int i3) {
        String str = (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) ? 2 : 3];
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i3 == 1) {
            objArr[1] = "asString";
        } else if (i3 == 2) {
            objArr[1] = "getIdentifier";
        } else if (i3 == 3 || i3 == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "identifierIfValid";
                break;
            case 8:
                objArr[2] = JsonKeywords.SPECIAL;
                break;
            case 9:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static Name g(String str) {
        if (str == null) {
            a(9);
        }
        return str.startsWith("<") ? n(str) : i(str);
    }

    public static Name i(String str) {
        if (str == null) {
            a(5);
        }
        return new Name(str, false);
    }

    public static boolean m(String str) {
        if (str == null) {
            a(6);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '.' || cCharAt == '/' || cCharAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static Name n(String str) {
        if (str == null) {
            a(8);
        }
        if (str.startsWith("<")) {
            return new Name(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    public String c() {
        String str = this.f154659a;
        if (str == null) {
            a(1);
        }
        return str;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Name name) {
        return this.f154659a.compareTo(name.f154659a);
    }

    public String e() {
        if (this.f154660b) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String strC = c();
        if (strC == null) {
            a(2);
        }
        return strC;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        return this.f154660b == name.f154660b && this.f154659a.equals(name.f154659a);
    }

    public int hashCode() {
        return (this.f154659a.hashCode() * 31) + (this.f154660b ? 1 : 0);
    }

    public boolean j() {
        return this.f154660b;
    }

    public String toString() {
        return this.f154659a;
    }
}
