package freemarker.template.utility;

import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes8.dex */
public class OptimizerUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final BigInteger f150764a = new BigInteger(Integer.toString(Integer.MIN_VALUE));

    /* renamed from: b, reason: collision with root package name */
    public static final BigInteger f150765b = new BigInteger(Integer.toString(Integer.MAX_VALUE));

    /* renamed from: c, reason: collision with root package name */
    public static final BigInteger f150766c = new BigInteger(Long.toString(Long.MIN_VALUE));

    /* renamed from: d, reason: collision with root package name */
    public static final BigInteger f150767d = new BigInteger(Long.toString(Long.MAX_VALUE));

    private OptimizerUtil() {
    }

    public static Number a(Number number) {
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            if (bigDecimal.scale() == 0) {
                number = bigDecimal.unscaledValue();
            } else {
                double dDoubleValue = bigDecimal.doubleValue();
                if (dDoubleValue != Double.POSITIVE_INFINITY && dDoubleValue != Double.NEGATIVE_INFINITY) {
                    return new Double(dDoubleValue);
                }
            }
        }
        if (!(number instanceof BigInteger)) {
            return number;
        }
        BigInteger bigInteger = (BigInteger) number;
        return (bigInteger.compareTo(f150765b) > 0 || bigInteger.compareTo(f150764a) < 0) ? (bigInteger.compareTo(f150767d) > 0 || bigInteger.compareTo(f150766c) < 0) ? number : new Long(bigInteger.longValue()) : new Integer(bigInteger.intValue());
    }
}
