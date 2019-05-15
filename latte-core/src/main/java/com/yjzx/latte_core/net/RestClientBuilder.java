package com.yjzx.latte_core.net;

import android.content.Context;
import com.yjzx.latte_core.net.callback.IError;
import com.yjzx.latte_core.net.callback.IFailure;
import com.yjzx.latte_core.net.callback.IRequest;
import com.yjzx.latte_core.net.callback.ISuccess;
import com.yjzx.latte_core.ui.LoaderStyle;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author jmf
 * @date 2019/5/14 15:20
 * @desc
 */
public class RestClientBuilder {
    private String mUrl = null;
    private static final Map<String,Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;
    private File mFile = null;

    RestClientBuilder(){

    }

    public final RestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String,Object> params){
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value){
        PARAMS.put(key,value);
        return this;
    }

    public final RestClientBuilder file(File file){
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String path){
        this.mFile = new File(path);
        return this;
    }

    public final RestClientBuilder raw(String raw){
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest){
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess){
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure){
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError){
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle style){
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }

    public final RestClientBuilder loader(Context context){
        this.mContext = context;
        this.mLoaderStyle =  LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }


    public final RestClient build(){
        return new RestClient(mUrl,PARAMS,mIRequest,mISuccess,mIFailure,mIError,mBody,mFile,mContext,mLoaderStyle);
    }
}
