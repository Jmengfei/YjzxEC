package com.yjzx.latte_core.delegates.bottom;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import com.yjzx.latte_core.R;
import com.yjzx.latte_core.delegates.LatteDelegate;

/**
 * @author jmf
 * @date 2019/5/16 14:07
 * @desc
 */
public abstract class BottomItemDelegate extends LatteDelegate implements View.OnKeyListener{

    private long mExitTime = 0;
    private static final int EXIT_TIME = 2000;

    @Override
    public void onResume() {
        super.onResume();
        final View rootView = getView();
        if (rootView != null){
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if ((System.currentTimeMillis() - mExitTime) > EXIT_TIME){
                Toast.makeText(getContext(),"双击退出"+getString(R.string.app_name),Toast.LENGTH_LONG).show();
                mExitTime = System.currentTimeMillis();
            }else{
                _mActivity.finish();
                if (mExitTime != 0){
                    mExitTime = 0;
                }
            }
            return true;
        }
        return false;
    }
}
