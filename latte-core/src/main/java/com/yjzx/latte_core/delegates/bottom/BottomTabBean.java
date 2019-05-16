package com.yjzx.latte_core.delegates.bottom;

/**
 * @author jmf
 * @date 2019/5/16 14:16
 * @desc
 */
public class BottomTabBean {

    private final CharSequence ICON;
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}
