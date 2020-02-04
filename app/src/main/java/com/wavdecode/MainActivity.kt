package com.wavdecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView



class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var metaText : TextView
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.first_wav_txt->{
                metaText.text = getWaveData(R.raw.file_1)
            }
            R.id.second_wav_txt->{
                metaText.text = getWaveData(R.raw.file_2)
            }
            R.id.third_wav_txt->{
                metaText.text = getWaveData(R.raw.file_3)
            }
        }
    }

    private fun getWaveData(fileName :Int) =
        WavDataReader(resources.openRawResource(fileName)).readWavData().toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        metaText = findViewById(R.id.wav_meta_txt)
        findViewById<TextView>(R.id.first_wav_txt).setOnClickListener(this)
        findViewById<TextView>(R.id.second_wav_txt).setOnClickListener(this)
        findViewById<TextView>(R.id.third_wav_txt).setOnClickListener(this)
    }
}
