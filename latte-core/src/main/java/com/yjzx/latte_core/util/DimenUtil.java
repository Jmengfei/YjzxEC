package com.yjzx.latte_core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.yjzx.latte_core.app.Latte;

/**
 * @author jmf
 * @date 2019/5/14 16:55
 * @desc 测量的工具类
 */
public class DimenUtil {

    public static int getScreenWidth(){
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
