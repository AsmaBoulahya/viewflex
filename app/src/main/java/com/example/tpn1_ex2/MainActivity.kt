package com.example.tpn1_ex2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var buttonShow: Button
    private lateinit var textWelcome: TextView

    companion object {
        private const val KEY_NAME = "key_name"
        private const val KEY_MESSAGE = "key_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        buttonShow = findViewById(R.id.buttonShow)
        textWelcome = findViewById(R.id.textWelcome)

        // Restaurer l'état si disponible
        if (savedInstanceState != null) {
            editTextName.setText(savedInstanceState.getString(KEY_NAME, ""))
            textWelcome.text = savedInstanceState.getString(KEY_MESSAGE, "")
        }

        buttonShow.setOnClickListener {
            val name = editTextName.text.toString().trim()
            if (name.isNotEmpty()) {
                textWelcome.text = "Bienvenue, $name !"
            } else {
                textWelcome.text = ""
            }
        }
    }

    // Sauvegarder l'état avant la rotation ou arrêt
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NAME, editTextName.text.toString())
        outState.putString(KEY_MESSAGE, textWelcome.text.toString())
    }
}
