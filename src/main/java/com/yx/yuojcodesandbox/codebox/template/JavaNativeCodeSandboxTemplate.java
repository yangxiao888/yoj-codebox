package com.yx.yuojcodesandbox.codebox.template;


import com.yx.yuojcodesandbox.model.ExecuteCodeRequest;
import com.yx.yuojcodesandbox.model.ExecuteCodeResponse;
import org.springframework.stereotype.Component;

/**
 * Java 语言的代码沙箱（直接复用模板方法实现）
 */
@Component
public class JavaNativeCodeSandboxTemplate extends CodeSandboxTemplate {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest request) {
        return super.executeCode(request);
    }
}

