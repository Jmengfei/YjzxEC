package com.yjzx.latte_core.app;

import android.content.Context;
import android.os.Handler;

import java.util.WeakHashMap;

/**
 * @author jmf
 * @date 2019/5/14 12:12
 * @desc 对外工具类
 */
public final class Latte {

    public static Configurator init(Context context){
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT,context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }

}
