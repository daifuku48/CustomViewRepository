package com.androismathhartdangame.customviewrepository

import android.os.Bundle
import com.androismathhartdangame.customviewrepository.databinding.ActivityMainBinding

class MainActivity: BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 0..15){
            binding.customLinearLayout.addItem(getString(R.string.item, i))
        }
    }
}