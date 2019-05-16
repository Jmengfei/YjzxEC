package com.yjzx.yjzxec;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.yjzx.latte.ec.launcher.LauncherDelegate;
import com.yjzx.latte.ec.launcher.LauncherScrollDelegate;
import com.yjzx.latte.ec.sign.ISignListener;
import com.yjzx.latte.ec.sign.SignInDelegate;
import com.yjzx.latte.ec.sign.SignUpDelegate;
import com.yjzx.latte_core.activities.ProxyActivity;
import com.yjzx.latte_core.delegates.LatteDelegate;
import com.yjzx.latte_core.ui.launcher.ILauncherListener;
import com.yjzx.latte_core.ui.launcher.OnLauncherFinishTag;

public class ExampleActivity extends ProxyActivity implements ISignListener, ILauncherListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag){
            case SIGNED:
                Toast.makeText(this,"启动结束，用户已经登录",Toast.LENGTH_LONG).show();
                startWithPop(new ExampleDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this,"启动结束，用户没有登录",Toast.LENGTH_LONG).show();
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
