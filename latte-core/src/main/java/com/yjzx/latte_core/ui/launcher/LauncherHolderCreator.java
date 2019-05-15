package com.yjzx.latte_core.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * @author jmf
 * @date 2019/5/15 15:31
 * @desc
 */
public class LauncherHolderCreator implements CBViewHolderCreator {
    @Override
    public Object createHolder() {
        return new LauncherHolder();
    }
}
