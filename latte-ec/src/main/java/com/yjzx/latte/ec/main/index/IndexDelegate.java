package com.yjzx.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.yjzx.latte.ec.R;
import com.yjzx.latte_core.delegates.bottom.BottomItemDelegate;

/**
 * @author jmf
 * @date 2019/5/16 15:18
 * @desc
 */
public class IndexDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
