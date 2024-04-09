package com.example.favorite_android.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.favorite_android.common.Constants.Companion.TABLE_NAME_ROOM_TEST
import com.example.favorite_android.db.bean.RoomTestBean

/**
 * Desc:  Room 数据库实例 Dao
 * Date:  24/10/22
 * Author: Makka
 * Email: 2364306586@qq.com
 */
@Dao
interface RoomTestDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(testInfo: RoomTestBean)

  /**
   * 获取全部数据
   */
  @Query("SELECT * FROM $TABLE_NAME_ROOM_TEST")
  suspend fun getAllRoomTestInfo(): List<RoomTestBean>

}