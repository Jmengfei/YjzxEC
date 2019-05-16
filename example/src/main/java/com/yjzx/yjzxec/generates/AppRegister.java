package com.yjzx.yjzxec.generates;

import com.yjzx.latte_annotation.annotations.AppRegisterGenerator;
import com.yjzx.latte_core.wechat.templates.AppRegisterTemplate;

/**
 * @author jmf
 * @date 2019/5/16 11:40
 * @desc
 */

@AppRegisterGenerator(
        packageName = "com.yjzx.yjzxec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
