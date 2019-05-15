package com.yjzx.yjzxec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.yjzx.latte_core.delegates.LatteDelegate;
import com.yjzx.latte_core.net.RestClient;
import com.yjzx.latte_core.net.callback.IError;
import com.yjzx.latte_core.net.callback.IFailure;
import com.yjzx.latte_core.net.callback.ISuccess;

/**
 * @author jmf
 * @date 2019/5/14 14:38
 * @desc
 */
public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient(){
        RestClient.builder()
                .url("http://127.0.0.1/index")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Log.d("hahaha onSuccess",response);
                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.d("hahaha onFailure","-----");
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Log.d("hahaha onError",code+"---"+msg);
                    }
                })
                .build()
                .get();
    }
}
