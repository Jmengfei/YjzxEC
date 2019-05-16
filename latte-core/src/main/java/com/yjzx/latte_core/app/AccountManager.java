package com.yjzx.latte_core.app;

import com.yjzx.latte_core.util.storage.LattePreference;

/**
 * @author jmf
 * @date 2019/5/15 18:10
 * @desc
 */
public class AccountManager {

    private enum SignTag{
        SIGN_TAG
    }

    // 保存用户登录状态，登录后调用
    public static void setSignState(boolean state){
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(),state);
    }

    private static boolean isSignTn(){
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker){
        if (isSignTn()){
            checker.onSignIn();
        }else{
            checker.onNotSignIn();
        }
    }
}
