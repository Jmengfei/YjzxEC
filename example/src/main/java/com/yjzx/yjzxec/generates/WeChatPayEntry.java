package com.yjzx.yjzxec.generates;


import com.yjzx.latte_annotation.annotations.PayEntryGenerator;
import com.yjzx.latte_core.wechat.templates.WXPayEntryTemplate;

/**
 * @author jmf
 * @date 2019/5/16 11:40
 * @desc
 */
@PayEntryGenerator(
        packageName = "com.yjzx.yjzxec",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
