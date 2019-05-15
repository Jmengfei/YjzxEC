package com.yjzx.latte_core.app;

import okhttp3.Interceptor;

import java.util.ArrayList;
import java.util.WeakHashMap;

/**
 * @author jmf
 * @date 2019/5/14 12:15
 * @desc 配置文件的存储和获取
 */
public class Configurator {

    private static final WeakHashMap<Object,Object> LATTE_CONFIGS = new WeakHashMap<>();

    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();


    private Configurator(){
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY,false);
    }

    static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    final WeakHashMap<Object,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure(){
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY,true);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigKeys.API_HOST,host);
        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptor){
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR,INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors){
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR,INTERCEPTORS);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady){
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = LATTE_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) LATTE_CONFIGS.get(key);
    }

}
