package com.yjzx.yjzxec;

import android.app.Application;
import com.yjzx.latte_core.app.Latte;

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
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
