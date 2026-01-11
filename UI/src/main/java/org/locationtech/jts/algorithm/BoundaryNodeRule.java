package org.locationtech.jts.algorithm;

/* loaded from: classes5.dex */
public interface BoundaryNodeRule {
    public static final BoundaryNodeRule ENDPOINT_BOUNDARY_RULE;
    public static final BoundaryNodeRule MOD2_BOUNDARY_RULE;
    public static final BoundaryNodeRule MONOVALENT_ENDPOINT_BOUNDARY_RULE;
    public static final BoundaryNodeRule MULTIVALENT_ENDPOINT_BOUNDARY_RULE;
    public static final BoundaryNodeRule OGC_SFS_BOUNDARY_RULE;

    public static class EndPointBoundaryNodeRule implements BoundaryNodeRule {
        @Override // org.locationtech.jts.algorithm.BoundaryNodeRule
        public boolean a(int i3) {
            return i3 > 0;
        }

        public String toString() {
            return "EndPoint Boundary Node Rule";
        }
    }

    public static class Mod2BoundaryNodeRule implements BoundaryNodeRule {
        @Override // org.locationtech.jts.algorithm.BoundaryNodeRule
        public boolean a(int i3) {
            return i3 % 2 == 1;
        }

        public String toString() {
            return "Mod2 Boundary Node Rule";
        }
    }

    public static class MonoValentEndPointBoundaryNodeRule implements BoundaryNodeRule {
        @Override // org.locationtech.jts.algorithm.BoundaryNodeRule
        public boolean a(int i3) {
            return i3 == 1;
        }

        public String toString() {
            return "MonoValent EndPoint Boundary Node Rule";
        }
    }

    public static class MultiValentEndPointBoundaryNodeRule implements BoundaryNodeRule {
        @Override // org.locationtech.jts.algorithm.BoundaryNodeRule
        public boolean a(int i3) {
            return i3 > 1;
        }

        public String toString() {
            return "MultiValent EndPoint Boundary Node Rule";
        }
    }

    static {
        Mod2BoundaryNodeRule mod2BoundaryNodeRule = new Mod2BoundaryNodeRule();
        MOD2_BOUNDARY_RULE = mod2BoundaryNodeRule;
        ENDPOINT_BOUNDARY_RULE = new EndPointBoundaryNodeRule();
        MULTIVALENT_ENDPOINT_BOUNDARY_RULE = new MultiValentEndPointBoundaryNodeRule();
        MONOVALENT_ENDPOINT_BOUNDARY_RULE = new MonoValentEndPointBoundaryNodeRule();
        OGC_SFS_BOUNDARY_RULE = mod2BoundaryNodeRule;
    }

    boolean a(int i3);
}
