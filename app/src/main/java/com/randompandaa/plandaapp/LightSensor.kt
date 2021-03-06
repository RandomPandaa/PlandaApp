package com.randompandaa.plandaapp

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class LightSensor : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var brightness: Sensor? = null
    private lateinit var text: TextView
    private lateinit var pb: CircularProgressBar
    private lateinit var back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_sensor)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        text = findViewById(R.id.tv_text)
        pb = findViewById(R.id.circularProgressBar)
        back = findViewById(R.id.back_btn)

        setUpSensorStuff()

        back.setOnClickListener(View.OnClickListener { startActivity(Intent(this, MainActivity::class.java))
            Toast.makeText(this, "Back to Menu", Toast.LENGTH_SHORT).show();

        });
    }

    private fun setUpSensorStuff() {
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        brightness = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_LIGHT) {
            val light1 = event.values[0]

            text.text = "Sensor: $light1\n${brightness(light1)}"
            pb.setProgressWithAnimation(light1)
        }
    }

    private fun brightness(brightness: Float): String {
        // Plant brightness reference from:
        // https://www.houseplantjournal.com/bright-indirect-light-requirements-by-plant/
        return when (brightness.toInt()) {
            0 -> "No Light Found - Use a fake plant"
            in 1..10 -> "Very Very little light found"
            in 11..50 -> "This is very dark"
            in 1000..2500 -> "Suitable for Monstera Plant, Money Plant"
            in 2501..5000 -> "Suitbale for SunFlower Plant."
            in 5001..7000 -> "Suitable for Yucca Plant"
            in 5001..25000 -> "Incredibly bright"
            in 25001..50000 -> "This is light will blind you"
            else -> "Point your light sensor towards a light source"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

    override fun onResume() {
        super.onResume()
        // Register a listener for the sensor.
        sensorManager.registerListener(this, brightness, SensorManager.SENSOR_DELAY_NORMAL)
    }


    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }



}
