package com.yx.yuojcodesandbox.controller;

import cn.hutool.crypto.digest.MD5;
import com.yx.yuojcodesandbox.codebox.template.JavaDockerCodeSandboxTemplate;
import com.yx.yuojcodesandbox.codebox.template.JavaNativeCodeSandboxTemplate;
import com.yx.yuojcodesandbox.model.ExecuteCodeRequest;
import com.yx.yuojcodesandbox.model.ExecuteCodeResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
//@RequestMapping("/")
public class CodeSandboxController {
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = MD5.create().digestHex16("secretKey");

    //@Resource
    //private JavaDockerCodeSandboxTemplate javaNativeCodeSandbox;

    @Resource
    private JavaNativeCodeSandboxTemplate javaNativeCodeSandbox;

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    @PostMapping("/executeCode")
    ExecuteCodeResponse executeCode(@RequestBody ExecuteCodeRequest executeCodeRequest, HttpServletRequest request, HttpServletResponse response) {
        String  header = request.getHeader(AUTH_REQUEST_HEADER);
        if(!AUTH_REQUEST_SECRET.equals(header)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }
        if (executeCodeRequest == null) {
            throw new RuntimeException("请求参数为空");
        }
        return javaNativeCodeSandbox.executeCode(executeCodeRequest);
    }



}
