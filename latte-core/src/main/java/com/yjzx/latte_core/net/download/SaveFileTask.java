package com.yjzx.latte_core.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.yjzx.latte_core.app.Latte;
import com.yjzx.latte_core.net.callback.IRequest;
import com.yjzx.latte_core.net.callback.ISuccess;
import com.yjzx.latte_core.util.file.FileUtil;
import okhttp3.ResponseBody;

import java.io.File;
import java.io.InputStream;

/**
 * @author jmf
 * @date 2019/5/15 10:39
 * @desc 慕课网徐宜生
 */
public class SaveFileTask extends AsyncTask<Object,Void, File> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;

    public SaveFileTask(IRequest REQUEST, ISuccess SUCCESS) {
        this.REQUEST = REQUEST;
        this.SUCCESS = SUCCESS;
    }

    @Override
    protected File doInBackground(Object... params) {
        String downloadDir = (String) params[0];
        String extension = (String) params[1];
        final ResponseBody body = (ResponseBody) params[2];
        final String name = (String) params[3];
        final InputStream is = body.byteStream();
        if (downloadDir == null || downloadDir.equals("")){
            downloadDir = "down_loads";
        }
        if (extension == null || extension.equals("")){
            extension = "";
        }

        if (name == null){
            return FileUtil.writeToDisk(is,downloadDir,extension.toUpperCase(),extension);
        }else{
            return FileUtil.writeToDisk(is, downloadDir,name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (SUCCESS != null){
            SUCCESS.onSuccess(file.getPath());
        }
        if (REQUEST != null){
            REQUEST.onRequestEnd();
        }
    }

    private void autoInstallApk(File file){
        if (FileUtil.getExtension(file.getPath()).equals("apk")){
            final Intent install = new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
            Latte.getApplicationContext().startActivity(install);
        }
    }
}
