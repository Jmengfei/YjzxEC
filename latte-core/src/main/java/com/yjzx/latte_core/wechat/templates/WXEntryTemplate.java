package com.yjzx.latte_core.wechat.templates;

import com.yjzx.latte_core.wechat.BaseWXEntryActivity;
import com.yjzx.latte_core.wechat.LatteWeChat;

/**
 * @author jmf
 * @date 2019/5/16 11:37
 * @desc
 */
public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
