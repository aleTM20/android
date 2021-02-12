package mosere.net.example

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sumarBtn: Button = findViewById(R.id.sum_button)
        val numOne: EditText = findViewById(R.id.num1_txt)
        val numTwo: EditText = findViewById(R.id.num2_txt)

        sumarBtn.setOnClickListener {
            try {
                val suma: Int = numOne.text.toString().toInt() + numTwo.text.toString().toInt()
                Toast.makeText(this, "Resultado: $suma", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Log.e("Error:", e.toString())
            }
        }
    }
}