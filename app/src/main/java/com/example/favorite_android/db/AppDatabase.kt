package com.example.favorite_android.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.favorite_android.db.bean.RoomTestBean
import com.example.favorite_android.db.dao.RoomTestDao
import com.example.favorite_android.getDefaultApp

/**
 * Description: room 数据库
 * Date: 2024/3/29
 * Author: Makka
 * Email: 2364306586@qq.com
 */
@Database(
  entities = [
    RoomTestBean::class
  ],
  version = 1,
  autoMigrations = [

  ]
)
abstract class AppDatabase : RoomDatabase() {

  abstract fun roomTestDao() : RoomTestDao

  companion object {
    // 单例的数据库操作类
    @Volatile
    private var mInstance: AppDatabase? = null

    @JvmStatic
    fun getInstance(context: Context = getDefaultApp()): AppDatabase {
      return mInstance ?: synchronized(this) {
        mInstance ?: buildDatabase(context).also { mInstance = it }
      }
    }

    const val DATABASE_NAME_TEST = "database_name_test"

    /**
     * 创建数据库
     */
    private fun buildDatabase(context: Context): AppDatabase {
      val builder = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,DATABASE_NAME_TEST)
      return builder.build()
    }
  }

}