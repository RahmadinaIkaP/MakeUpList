package binar.academy.makeuplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.makeuplist.R
import binar.academy.makeuplist.databinding.ActivityMainBinding
import binar.academy.makeuplist.viewmodel.MakeUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRvMakeUp()
    }

    private fun setRvMakeUp() {
        val viewModel = ViewModelProvider(this)[MakeUpViewModel::class.java]
        viewModel.showAllDataMakeUp()
        viewModel.getLiveDataMakeUp().observe(this){
            if (it != null){
                binding.rvMakeUp.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvMakeUp.adapter = MakeUpAdapter(it)
            }
        }
    }
}