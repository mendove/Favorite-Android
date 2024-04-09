package com.example.favorite_android.db.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.favorite_android.common.Constants

/**
 * Description:  Room test 实体类
 * Date: 2024/3/29
 * Author: Makka
 * Email: 2364306586@qq.com
 */
@Entity(tableName = Constants.TABLE_NAME_ROOM_TEST)
data class RoomTestBean(
  @ColumnInfo(name = "user_id")
  @PrimaryKey(autoGenerate = true)
  val userId: Long = 0,  // 用户 id （编号）
  @ColumnInfo(name = "user_name")
  val userName: String = "", // 用户名
  val password: String = "",  // 密码
  @ColumnInfo(name = "login_time")
  val loginTime: Long? = null  // 最后登录时间
)