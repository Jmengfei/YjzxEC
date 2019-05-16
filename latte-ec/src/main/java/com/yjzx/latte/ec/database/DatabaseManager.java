package com.yjzx.latte.ec.database;

import android.content.Context;
import org.greenrobot.greendao.database.Database;

/**
 * @author jmf
 * @date 2019/5/15 17:49
 * @desc
 */
public class DatabaseManager {
    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    private DatabaseManager(){

    }

    public DatabaseManager init(Context context){
        initDao(context);
        return this;
    }


    private static final class Holder{
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance(){
        return Holder.INSTANCE;
    }

    private void initDao(Context context){
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context,"fast_ec.db");
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }

    public final UserProfileDao getDao(){
        return mDao;
    }
}
