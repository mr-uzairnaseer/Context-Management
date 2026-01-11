package org.apache.commons.lang3.concurrent.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/* loaded from: classes7.dex */
public class LockingVisitors {

    public static class LockVisitor<O, L> {
    }

    public static class ReadWriteLockVisitor<O> extends LockVisitor<O, ReadWriteLock> {
    }

    public static class StampedLockVisitor<O> extends LockVisitor<O, StampedLock> {
    }

    @Deprecated
    public LockingVisitors() {
    }
}
