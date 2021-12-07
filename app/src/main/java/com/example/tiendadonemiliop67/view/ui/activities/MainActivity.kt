package com.example.tiendadonemiliop67.view.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tiendadonemiliop67.R
import com.example.tiendadonemiliop67.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configNav()
    }

    fun configNav(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragContent) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bnvMenu).setupWithNavController(navController)
    }

   override fun onRequestPermissionsResult(
        requestCode:Int ,
        permissions: Array <out String>,
        grantResults: IntArray
    ){
        val permissionsToRequest= ArrayList<String>()
        var  i =0
        while (i < grantResults.size){
            permissionsToRequest.add(permissions[i])
            i++
        }
        if (permissionsToRequest.size>0){
            ActivityCompat.requestPermissions(
                this,
                permissionsToRequest.toTypedArray(),
                REQUEST_PERMISSIONS_REQUEST_CODE
                   )
        }

    }
}