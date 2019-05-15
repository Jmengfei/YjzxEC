package com.yjzx.latte_core.net.interceptors;

import okhttp3.*;

import java.util.LinkedHashMap;

/**
 * @author jmf
 * @date 2019/5/15 12:14
 * @desc
 */
public abstract class BaseInterceptor implements Interceptor {

    protected LinkedHashMap<String,String> getUrlParameters(Chain chain){
        final HttpUrl url = chain.request().url();
        int size = url.querySize();
        final LinkedHashMap<String,String> params = new LinkedHashMap<>();
        for (int i = 0 ; i < size; i++){
            params.put(url.queryParameterName(i),url.queryParameterValue(i));
        }
        return params;
    }

    protected String getUrlParameters(Chain chain,String key){
        final Request request = chain.request();
        return request.url().queryParameter(key);
    }

    protected LinkedHashMap<String,String> getBodyParameters(Chain chain){
        final FormBody formBody = (FormBody) chain.request().body();
        final LinkedHashMap<String,String> params = new LinkedHashMap<>();
        int size = formBody.size();
        for(int i = 0 ; i < size ; i++){
            params.put(formBody.name(i),formBody.value(i));
        }
        return params;
    }

    protected String getBodyParameters(Chain chain, String key){
        return getBodyParameters(chain).get(key);
    }
}
