package com.androismathhartdangame.customviewrepository

import android.os.Bundle
import com.androismathhartdangame.customviewrepository.databinding.ActivityMainBinding
import com.androismathhartdangame.customviewrepository.databinding.ItemLayoutBinding

class MainActivity: BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 0..15){
            val itemBinding = ItemLayoutBinding.inflate(layoutInflater)
            itemBinding.itemText.text = getString(R.string.item, i)
            binding.customLinearLayout.addItem(itemBinding.itemText)
        }
    }
}