package com.androismathhartdangame.customviewrepository

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null
    protected val binding
        get() = requireNotNull(_binding) { "Binding can be accessed after OnCreateView" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingClass = (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<VB>
        val inflate = bindingClass.getMethod(
            "inflate",
            LayoutInflater::class.java
        )
        _binding = inflate.invoke(null, layoutInflater) as VB
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}