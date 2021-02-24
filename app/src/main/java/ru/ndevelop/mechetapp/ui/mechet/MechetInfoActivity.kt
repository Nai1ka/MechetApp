package ru.ndevelop.mechetapp.ui.mechet

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.ndevelop.mechetapp.R
import ru.ndevelop.mechetapp.ui.tools.MechetType

class MechetInfoActivity : AppCompatActivity() {
    private var mechetId = 0
    private lateinit var mechetImage: ImageView
    private lateinit var mechetName: TextView
    private lateinit var mechetDescription: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_mechet_info)
        val b = intent.extras
        if (b != null) mechetId = b.getInt("mechetId")
        mechetImage = findViewById(R.id.iv_mechet)
        mechetName = findViewById(R.id.tv_mechet_name)
        mechetName.text = MechetType.values()[mechetId].mechetName
        mechetDescription = findViewById(R.id.tv_mechet_description)
    }
}