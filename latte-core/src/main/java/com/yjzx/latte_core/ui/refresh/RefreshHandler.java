package com.yjzx.latte_core.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import com.yjzx.latte_core.app.Latte;

/**
 * @author jmf
 * @date 2019/5/16 16:16
 * @desc
 */
public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout refreshLayout) {
        this.REFRESH_LAYOUT = refreshLayout;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    private void refresh(){
        REFRESH_LAYOUT.setRefreshing(true);

        // 模拟网络请求
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                REFRESH_LAYOUT.setRefreshing(false);
            }
        },2000);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
