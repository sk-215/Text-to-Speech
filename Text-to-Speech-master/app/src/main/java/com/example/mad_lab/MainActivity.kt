package com.example.mad_lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener {
    lateinit var etspeak : EditText
    lateinit var btspeak : Button
    lateinit var tts : TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etspeak=findViewById(R.id.etspeak)
        btspeak=findViewById(R.id.btspeak)
        btspeak.isEnabled=false
        tts=TextToSpeech(this,this)

        btspeak.setOnClickListener {speakOut() }
    }

    private fun speakOut() {
        val text =etspeak.text.toString()
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onInit(status: Int) {
        if (status==TextToSpeech.SUCCESS) {
            val result = tts.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
            }
            else{
                btspeak.isEnabled=true
            }
        }
    }
}