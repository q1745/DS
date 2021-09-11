package com.example.stockpile

import android.content.Context
import com.example.stockpile.db.DaoMaster
import com.example.stockpile.db.UserDao

/**
@Name:yao
@CreateDate: 2021/9/11 9:12
@ProjectName: DS
@Package: com.example.stockpile
@ClassName: DaoUser
 */
class DaoUser private constructor(context: Context){
    var userDao:UserDao
    init {
        val devOpenHelper = DaoMaster.DevOpenHelper(context, "sql", null)
        val writableDb = devOpenHelper.writableDb
        val daoMaster = DaoMaster(writableDb)
        val newSession = daoMaster.newSession()
        this.userDao=newSession.userDao
    }

    /**
     * 伴生
     */
    companion object{
        var dao:DaoUser? =null
        fun getdaouser(context: Context):DaoUser?{
            if (dao==null){
                @Synchronized
                if (dao==null){
                    dao=DaoUser(context)
                }
            }
            return dao
        }
    }

    /**
     * 添加数据
     */
    fun getinsert(user:User){
        userDao.insert(user)
    }

    /**
     * 删除数据
     */
    fun getdelet(user:User){
        userDao.delete(user)
    }

    /**
     * 修改数据
     */
    fun getupdata(user:User){
        userDao.update(user)
    }

    /**
     * 查询数据
     */
    fun getquest(name:String):List<User>{
        val list=userDao.queryBuilder().list()
        return list
    }
}