package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes4.dex */
public class BaselineLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public int f65892a;

    public BaselineLayout(Context context) {
        super(context, null, 0);
        this.f65892a = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f65892a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i5 - i3) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                int baseline = (this.f65892a == -1 || childAt.getBaseline() == -1) ? paddingTop : (this.f65892a + paddingTop) - childAt.getBaseline();
                childAt.layout(i8, baseline, measuredWidth + i8, measuredHeight + baseline);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i4) {
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        int iCombineMeasuredStates = 0;
        int iMax3 = -1;
        int iMax4 = -1;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i4);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    iMax3 = Math.max(iMax3, baseline);
                    iMax4 = Math.max(iMax4, childAt.getMeasuredHeight() - baseline);
                }
                iMax2 = Math.max(iMax2, childAt.getMeasuredWidth());
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        if (iMax3 != -1) {
            iMax = Math.max(iMax, Math.max(iMax4, getPaddingBottom()) + iMax3);
            this.f65892a = iMax3;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax2, getSuggestedMinimumWidth()), i3, iCombineMeasuredStates), View.resolveSizeAndState(Math.max(iMax, getSuggestedMinimumHeight()), i4, iCombineMeasuredStates << 16));
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f65892a = -1;
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f65892a = -1;
    }
}
