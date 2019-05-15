package com.yjzx.yjzxec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.yjzx.latte.ec.launcher.LauncherDelegate;
import com.yjzx.latte.ec.launcher.LauncherScrollDelegate;
import com.yjzx.latte_core.activities.ProxyActivity;
import com.yjzx.latte_core.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherScrollDelegate();
    }
}
