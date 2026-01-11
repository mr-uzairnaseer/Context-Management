package com.squareup.picasso;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface Cache {
    public static final Cache NONE = new Cache() { // from class: com.squareup.picasso.Cache.1
        @Override // com.squareup.picasso.Cache
        public Bitmap a(String str) {
            return null;
        }

        @Override // com.squareup.picasso.Cache
        public int b() {
            return 0;
        }

        @Override // com.squareup.picasso.Cache
        public void c(String str, Bitmap bitmap) {
        }

        @Override // com.squareup.picasso.Cache
        public void clear() {
        }

        @Override // com.squareup.picasso.Cache
        public void d(String str) {
        }

        @Override // com.squareup.picasso.Cache
        public int size() {
            return 0;
        }
    };

    Bitmap a(String str);

    int b();

    void c(String str, Bitmap bitmap);

    void clear();

    void d(String str);

    int size();
}
