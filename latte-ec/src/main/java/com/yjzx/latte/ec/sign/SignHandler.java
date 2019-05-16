package com.yjzx.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjzx.latte.ec.database.DatabaseManager;
import com.yjzx.latte.ec.database.UserProfile;
import com.yjzx.latte_core.app.AccountManager;
import com.yjzx.latte_core.util.storage.LattePreference;

/**
 * @author jmf
 * @date 2019/5/15 17:55
 * @desc
 */
public class SignHandler {

    public static void onSignIn(String response,ISignListener signListener){
        onSign(response);
        signListener.onSignInSuccess();
    }

    public static void onSignUp(String response,ISignListener signListener){
        onSign(response);
        signListener.onSignUpSuccess();
    }

    private static void onSign(String response){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
//        final long userId = profileJson.getLong("userId");
//        final String name = profileJson.getString("name");
//        final String avatar = profileJson.getString("avatar");
//        final String gender = profileJson.getString("gender");
//        final String address = profileJson.getString("address");

//        final UserProfile profile = new UserProfile(userId,name,avatar,gender,address);
//        DatabaseManager.getInstance().getDao().insert(profile);

        final String token = profileJson.getString("token");
        LattePreference.setAppProfile("token");

        // 登录成功
        AccountManager.setSignState(true);
    }
}
