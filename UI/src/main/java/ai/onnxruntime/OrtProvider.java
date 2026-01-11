package ai.onnxruntime;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum OrtProvider {
    CPU("CPUExecutionProvider"),
    CUDA("CUDAExecutionProvider"),
    DNNL("DnnlExecutionProvider"),
    OPEN_VINO("OpenVINOExecutionProvider"),
    VITIS_AI("VitisAIExecutionProvider"),
    TENSOR_RT("TensorrtExecutionProvider"),
    NNAPI("NnapiExecutionProvider"),
    RK_NPU("RknpuExecutionProvider"),
    DIRECT_ML("DmlExecutionProvider"),
    MI_GRAPH_X("MIGraphXExecutionProvider"),
    ACL("ACLExecutionProvider"),
    ARM_NN("ArmNNExecutionProvider"),
    ROCM("ROCMExecutionProvider"),
    CORE_ML("CoreMLExecutionProvider"),
    XNNPACK("XnnpackExecutionProvider"),
    AZURE("AzureExecutionProvider"),
    QNN("QNNExecutionProvider"),
    WEBGPU("WebGpuExecutionProvider");

    private static final Map<String, OrtProvider> valueMap = new HashMap(values().length);
    private final String name;

    static {
        for (OrtProvider ortProvider : values()) {
            valueMap.put(ortProvider.name, ortProvider);
        }
    }

    OrtProvider(String str) {
        this.name = str;
    }

    public static OrtProvider mapFromName(String str) {
        OrtProvider ortProvider = valueMap.get(str);
        if (ortProvider != null) {
            return ortProvider;
        }
        throw new IllegalArgumentException("Unknown execution provider - " + str);
    }

    public String getName() {
        return this.name;
    }
}
