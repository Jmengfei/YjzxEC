package com.yjzx.yjzxec.generates;

import com.yjzx.latte_annotation.annotations.EntryGenerator;
import com.yjzx.latte_core.wechat.templates.WXEntryTemplate;

/**
 * @author jmf
 * @date 2019/5/16 11:40
 * @desc
 */
@EntryGenerator(
     packageName = "com.yjzx.yjzxec",
     entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
