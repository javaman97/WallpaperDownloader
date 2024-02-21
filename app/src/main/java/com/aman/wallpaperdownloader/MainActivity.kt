package com.aman.wallpaperdownloader

import android.app.WallpaperManager
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aman.wallpaperdownloader.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDownload.setOnClickListener {
            if (binding.etxtUrl.text?.isEmpty() == true){
                Toast.makeText(applicationContext,"Please paste the URL",Toast.LENGTH_SHORT).show()
            }
            else {
                downloadWallpaper(binding.etxtUrl.text.toString())
            }
        }

        binding.btnSetWallpaper.setOnClickListener {
            val bitMap = (binding.imgWallpaper.drawable as BitmapDrawable).bitmap
            val wallpaperManager = WallpaperManager.getInstance(applicationContext)
            wallpaperManager.setBitmap(bitMap)

            Toast.makeText(applicationContext,"Wallpaper Set Successfully",Toast.LENGTH_SHORT).show()
        }
    }

    private fun downloadWallpaper(url:String) {
        Glide.with(applicationContext).load(url).into(binding.imgWallpaper)
    }
}