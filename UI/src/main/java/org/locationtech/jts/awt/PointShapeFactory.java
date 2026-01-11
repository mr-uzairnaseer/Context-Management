package org.locationtech.jts.awt;

/* loaded from: classes5.dex */
public interface PointShapeFactory {

    public static class Circle extends BasePointShapeFactory {
    }

    public static class Cross extends BasePointShapeFactory {
    }

    public static class Point extends BasePointShapeFactory {
    }

    public static class Square extends BasePointShapeFactory {
        public Square() {
        }

        public Square(double d3) {
            super(d3);
        }
    }

    public static class Star extends BasePointShapeFactory {
    }

    public static class Triangle extends BasePointShapeFactory {
    }

    public static class X extends BasePointShapeFactory {
    }

    public static abstract class BasePointShapeFactory implements PointShapeFactory {
        public static final double DEFAULT_SIZE = 3.0d;

        /* renamed from: a, reason: collision with root package name */
        public double f163307a;

        public BasePointShapeFactory() {
            this.f163307a = 3.0d;
        }

        public BasePointShapeFactory(double d3) {
            this.f163307a = d3;
        }
    }
}
