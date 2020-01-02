package com.test.aidlapp;

public class GreenDaoManager {

    public static GreenDaoManager instance;

    private DaoMaster daoMaster;

    private DaoSession daoSession;

    public GreenDaoManager() {
        if (instance == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(AppApplication.context, "test-db", null);
            daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            daoSession = daoMaster.newSession();
        }
    }

    public static GreenDaoManager getInstance() {
        if (instance == null) {
            synchronized (GreenDaoManager.class) {
                if (instance == null) {
                    instance = new GreenDaoManager();
                }
            }
        }
        return instance;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public DaoSession getSession() {
        return daoSession;
    }

    public DaoSession getNewSession() {
        daoSession = daoMaster.newSession();
        return daoSession;
    }


}
