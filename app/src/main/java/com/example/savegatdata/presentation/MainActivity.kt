package com.example.savegatdata.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.savegatdata.R
import com.example.savegatdata.data.repository.UserRepositoryImp
import com.example.savegatdata.data.storage.sharedpref.SharedPrefUserStorage
import com.example.savegatdata.databinding.ActivityMainBinding
import com.example.savegatdata.domain.models.SaveUserNameParams
import com.example.savegatdata.domain.usecase.GetUserNameUseCase
import com.example.savegatdata.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var saveUserNameUseCase: SaveUserNameUseCase
    private lateinit var getUserNameUseCase: GetUserNameUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        saveUserNameUseCase = SaveUserNameUseCase(UserRepositoryImp(SharedPrefUserStorage(this)))
        getUserNameUseCase = GetUserNameUseCase(UserRepositoryImp(SharedPrefUserStorage(this)))

        with(binding) {
            saveDataButton.setOnClickListener {
                val result =
                    saveUserNameUseCase(SaveUserNameParams(inputDataEditText.text.toString()))
                showDataTextView.text = getString(R.string.success, result.toString())
            }

            getDataButton.setOnClickListener {
                val userName = getUserNameUseCase()
                showDataTextView.text = getString(R.string.saved_data, userName.firstName, userName.lastName)
            }
        }
    }
}