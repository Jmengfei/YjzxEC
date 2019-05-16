package com.yjzx.yjzxec;

import android.app.Application;
import com.yjzx.latte.ec.database.DatabaseManager;
import com.yjzx.latte_core.app.Latte;
import com.yjzx.latte_core.net.interceptors.DebugInterceptor;

/**
 * @author jmf
 * @date 2019/5/14 12:13
 * @desc
 */
public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://appapi.yjzx.com/")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .configure();

        DatabaseManager.getInstance().init(this);
    }
}
