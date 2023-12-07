package com.cem.kronometre

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.cem.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var timeStop:Long=0
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply{
            buttonStart.setOnClickListener{
                tvKronometre.base = SystemClock.elapsedRealtime() + timeStop
                tvKronometre.start()

                buttonStart.visibility = View.GONE
                buttonPause.visibility = View.VISIBLE
                imageViewStart.setImageDrawable(getDrawable(R.drawable.pause))
            }

            buttonPause.setOnClickListener{
                timeStop = tvKronometre.base - SystemClock.elapsedRealtime()
                tvKronometre.stop()

                buttonStart.visibility = View.VISIBLE
                buttonPause.visibility = View.GONE
                imageViewStart.setImageDrawable(getDrawable(R.drawable.start))
            }

            buttonReset.setOnClickListener {
                tvKronometre.base = SystemClock.elapsedRealtime()
                tvKronometre.stop()
                timeStop = 0

                buttonStart.visibility = View.VISIBLE
                buttonPause.visibility = View.GONE
                imageViewStart.setImageDrawable(getDrawable(R.drawable.start))
            }
        }

    }
}