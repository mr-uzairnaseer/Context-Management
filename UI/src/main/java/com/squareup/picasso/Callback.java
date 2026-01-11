package com.squareup.picasso;

/* loaded from: classes5.dex */
public interface Callback {

    public static class EmptyCallback implements Callback {
        @Override // com.squareup.picasso.Callback
        public void a(Exception exc) {
        }

        @Override // com.squareup.picasso.Callback
        public void onSuccess() {
        }
    }

    void a(Exception exc);

    void onSuccess();
}
