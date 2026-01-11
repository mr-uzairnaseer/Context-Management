package ai.onnxruntime;

/* loaded from: classes2.dex */
public class NodeInfo {
    private final ValueInfo info;
    private final String name;

    public NodeInfo(String str, ValueInfo valueInfo) {
        this.name = str;
        this.info = valueInfo;
    }

    public ValueInfo getInfo() {
        return this.info;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "NodeInfo(name=" + this.name + ",info=" + this.info.toString() + ")";
    }
}
