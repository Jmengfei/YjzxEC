package com.yjzx.latte_core.util.timer;

import java.util.TimerTask;

/**
 * @author jmf
 * @date 2019/5/15 14:48
 * @desc 基础倒计时
 */
public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null){
            mITimerListener.onTimer();
        }
    }
}
