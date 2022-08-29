package com.example.data.storage.sharedpref

import android.content.Context
import com.example.data.storage.UserStorage
import com.example.data.storage.models.User

private const val SHARED_PREF_NAME = "shared_pref_user_name"
private const val FIRST_NAME_KEY = "first_name_key"
private const val LAST_NAME_KEY = "last_name_key"

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit()
            .putString(FIRST_NAME_KEY, user.firstName)
            .putString(LAST_NAME_KEY, user.lastName)
            .apply()
        return true
    }

    override fun get(): User {
        return User(sharedPreferences.getString(FIRST_NAME_KEY, "No data")!!, sharedPreferences.getString(
            LAST_NAME_KEY, "No data")!!)
    }
}