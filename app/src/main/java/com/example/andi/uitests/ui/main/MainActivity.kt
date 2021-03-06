package com.example.andi.uitests.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import com.example.andi.uitests.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        observe()
        viewModel.fetchData()
        setSupportActionBar(act_main_toolbar)
        supportActionBar?.title = getString(R.string.guys_title)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setupView() {
        act_main_rv_guys.adapter = MainAdapter()
        act_main_rv_guys.layoutManager = LinearLayoutManager(this)
    }

    private fun observe() {
        viewModel.guysList.observe(this, android.arch.lifecycle.Observer {
            (act_main_rv_guys.adapter as MainAdapter).updateData(it ?: return@Observer)
        })
    }
}
