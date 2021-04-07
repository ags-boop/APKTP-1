package edu.istea

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val palindromaInput : EditText = findViewById(R.id.input_palindroma);
        val ispalindroma: Button = findViewById(R.id.btn_btnispalindroma);
        val result : TextView = findViewById(R.id.text_result);

        val celsiusIpunt : EditText = findViewById(R.id.input_celsius);
        val convertTo: Button = findViewById(R.id.btn_convert);
        var resultConvert : TextView = findViewById(R.id.text_resultCelsius);

        ispalindroma.setOnClickListener(View.OnClickListener {
            var palindroma = palindromaInput.text.toString();
            palindroma = palindroma.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "")

            val reverse: String = StringBuilder(palindroma).reverse().toString()
            if(palindroma == reverse){
                result.setText("Es Palindroma :)")
            }
            else {
                result.setText("No es Palindroma :(")
            }

        })

        convertTo.setOnClickListener(View.OnClickListener {
            var celsiusValue = celsiusIpunt.text.toString().toDouble();
            var valueForm = ((celsiusValue*9)/5)+32.toDouble()
            resultConvert.setText("grados en fahrenheit:$valueForm°F")

        })





    }
}