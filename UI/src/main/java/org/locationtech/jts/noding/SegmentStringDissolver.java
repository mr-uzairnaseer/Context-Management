package org.locationtech.jts.noding;

import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes6.dex */
public class SegmentStringDissolver {

    /* renamed from: a, reason: collision with root package name */
    public SegmentStringMerger f163746a;

    /* renamed from: b, reason: collision with root package name */
    public Map f163747b;

    public interface SegmentStringMerger {
    }

    public SegmentStringDissolver(SegmentStringMerger segmentStringMerger) {
        this.f163747b = new TreeMap();
        this.f163746a = segmentStringMerger;
    }

    public SegmentStringDissolver() {
        this(null);
    }
}
