package com.yjzx.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.yjzx.latte.ec.R;
import com.yjzx.latte.ec.R2;
import com.yjzx.latte_core.delegates.LatteDelegate;
import com.yjzx.latte_core.net.RestClient;
import com.yjzx.latte_core.net.callback.IError;
import com.yjzx.latte_core.net.callback.IFailure;
import com.yjzx.latte_core.net.callback.ISuccess;
import com.yjzx.latte_core.util.log.LatteLogger;

/**
 * @author jmf
 * @date 2019/5/15 17:12
 * @desc
 */
public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_in_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;


    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn(){
        if (checkForm()){
            RestClient.builder()
                    .url("http://appapi.yjzx.com/api/login")
                    .params("username", mName.getText().toString())
                    .params("password", mPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE", response);
//                            SignHandler.onSignIn(response, mISignListener);
                        }
                    })
                    .failure(new IFailure() {
                        @Override
                        public void onFailure() {
                            LatteLogger.json("USER_PROFILE", "登录失败");
                        }
                    })
                    .error(new IError() {
                        @Override
                        public void onError(int code, String msg) {
                            LatteLogger.json("USER_PROFILE", code + "---"+msg);
                        }
                    })
                    .build()
                    .post();
        }
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat(){

    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink(){
        start(new SignUpDelegate());
    }


    private boolean checkForm(){
        final String name = mName.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()){
            mName.setError("请输入用户名");
            isPass = false;
        }else{
            mName.setError(null);
        }

        if (password.isEmpty() || password.length() < 6){
            mPassword.setError("请输入至少6位密码");
            isPass = false;
        }else {
            mPassword.setError(null);
        }

        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
