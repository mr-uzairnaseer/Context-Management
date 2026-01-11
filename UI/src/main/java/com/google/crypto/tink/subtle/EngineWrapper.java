package com.google.crypto.tink.subtle;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes5.dex */
public interface EngineWrapper<T> {

    public static class TCipher implements EngineWrapper<Cipher> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Cipher a(String str, Provider provider) {
            return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
        }
    }

    public static class TKeyAgreement implements EngineWrapper<KeyAgreement> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyAgreement a(String str, Provider provider) {
            return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
        }
    }

    public static class TKeyFactory implements EngineWrapper<KeyFactory> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyFactory a(String str, Provider provider) {
            return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
        }
    }

    public static class TKeyPairGenerator implements EngineWrapper<KeyPairGenerator> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyPairGenerator a(String str, Provider provider) {
            return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
        }
    }

    public static class TMac implements EngineWrapper<Mac> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Mac a(String str, Provider provider) {
            return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
        }
    }

    public static class TMessageDigest implements EngineWrapper<MessageDigest> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageDigest a(String str, Provider provider) {
            return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
        }
    }

    public static class TSignature implements EngineWrapper<Signature> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Signature a(String str, Provider provider) {
            return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        }
    }

    Object a(String str, Provider provider);
}
