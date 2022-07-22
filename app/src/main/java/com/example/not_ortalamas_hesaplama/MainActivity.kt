package com.example.not_ortalamas_hesaplama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.not_ortalamas_hesaplama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.buttonHesapla.setOnClickListener {
            if (binding.vize1.text.isNotEmpty() && binding.vize2.text.isNotEmpty() && binding.AgRlKVize.text.isNotEmpty() && binding.AgRlKFinal.text.isNotEmpty() && binding.FinalNot.text.isNotEmpty()) {

                //Vize
                val sinaviVize1 = binding.vize1.text.toString().toInt()
                val sinaviVize2 = binding.vize2.text.toString().toInt()
                val agirlikVize = binding.AgRlKVize.text.toString().toInt()
                val ortalamaVize: Double =
                    ((sinaviVize1 + sinaviVize2) / 2 * agirlikVize / 100).toDouble()

                //Final
                val agirlikFinal = binding.AgRlKFinal.text.toString().toInt()
                val sinavFinal = binding.FinalNot.text.toString().toInt()
                val ortalamaFinal: Double = ((sinavFinal * agirlikFinal) / 100).toDouble()

                val totalNots: Double = ortalamaVize + ortalamaFinal

                when (totalNots) {
                    in 0.0..50.0 -> {
                        binding.sonuText.text = totalNots.toString() + " " + "Notunuz : DD "
                        binding.sonuText.setTextColor(getColor(R.color.Red))
                    }
                    in 51.0..64.0 -> {
                        binding.sonuText.text = totalNots.toString() + " " + "Notunuz : DC "
                        binding.sonuText.setTextColor(getColor(R.color.Red))
                    }

                    in 65.0..69.0 -> {
                        binding.sonuText.text =
                            totalNots.toString() + " " + "Notunuz : CD "
                        binding.sonuText.setTextColor(getColor(R.color.Green))
                    }

                    in 70.0..74.0 -> {
                        binding.sonuText.text =
                            totalNots.toString() + " " + "Notunuz : CC "
                        binding.sonuText.setTextColor(getColor(R.color.Green))
                    }

                    in 75.0..79.0 -> {
                        binding.sonuText.text =
                            totalNots.toString() + " " + "Notunuz : CB "
                        binding.sonuText.setTextColor(getColor(R.color.Green))
                    }

                    in 80.0..84.0 -> {
                        binding.sonuText.text =
                            totalNots.toString() + " " + "Notunuz : BB "
                        binding.sonuText.setTextColor(getColor(R.color.Green))
                    }
                    in 85.0..89.0 -> {
                        binding.sonuText.text =
                            totalNots.toString() + " " + "Notunuz : BA "
                        binding.sonuText.setTextColor(getColor(R.color.Green))
                    }
                    in 90.0..100.0 -> {
                        binding.sonuText.text =
                            totalNots.toString() + " " + "Notunuz : AA "
                        binding.sonuText.setTextColor(getColor(R.color.Green))
                    }

                    else -> {
                        binding.sonuText.text =
                            totalNots.toString() + " " + "Hatalı not girdiniz."
                        binding.sonuText.setTextColor(getColor(R.color.Green))
                    }

                }


            } else {
                binding.sonuText.text = "Sınav Notunuzu giriniz."
                binding.sonuText.setTextColor(getColor(R.color.Red))
            }


        }
    }
}

