package com.example.speisekarteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.speisekarteapp.databinding.ActivityMainBinding
import kotlin.math.round

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {

    /* -------------------- Klassen Variablen -------------------- */
    private var bill: Float = 0f
    private val drink1 = Drink("Kaffee", 3.95f)
    private val drink2 = Drink("Wein", 4.20f)
    private val drink3 = Drink("Cocktail", 6.90f)

    /* -------------------- Lifecycle -------------------- */
    /**
     * Lifecycle Funktion, wird aufgerufen wenn Activity erstellt wird
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Lege hier die Binding Variable an
        // TODO Schreibe hier deinen Code
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Setze hier die Namen, Preise und Count in der View über die binding Variable
        // TODO Schreibe hier deinen Code
        binding.drink1Name.text = drink1.name
        binding.drink2Name.text = drink2.name
        binding.drink3Name.text = drink3.name

        val price1 = "%.2f".format(drink1.price)
        val price2 = "%.2f".format(drink2.price)
        val price3 = "%.2f".format(drink3.price)


        binding.drink1Price.text = price1
        binding.drink2Price.text = price2
        binding.drink3Price.text = price3

        binding.drink1Count.text = drink1.count.toString()
        binding.drink2Count.text = drink2.count.toString()
        binding.drink3Count.text = drink3.count.toString()

        // implementiere einen onClicklistener für das Kaffee Icon
        // TODO Schreibe hier deinen Code
        binding.drink1Button.setOnClickListener {
            addToBill(drink1.price)
            drink1.count++
            binding.drink1Count.text = drink1.count.toString()
            var deciStellen = "%.2f".format(bill)
            binding.totalPrice.text = deciStellen
        }

        // implementiere einen onClicklistener für das Wein Icon
        // TODO Schreibe hier deinen Code
        binding.drink2Button.setOnClickListener {
            addToBill(drink2.price)
            drink2.count++
            binding.drink2Count.text = drink2.count.toString()
            var deciStellen = "%.2f".format(bill)
            binding.totalPrice.text = deciStellen
        }

        // implementiere einen onClicklistener für das Cocktail Icon
        // TODO Schreibe hier deinen Code
        binding.drink3Button.setOnClickListener {
            addToBill(drink1.price)
            drink3.count++
            binding.drink3Count.text = drink3.count.toString()
            var deciStellen = "%.2f".format(bill)
            binding.totalPrice.text = deciStellen
        }
        // ResetFunktion
        // TODO Schreibe hier deinen Code
        binding.resetButton.setOnClickListener {
            drink1.count = 0
            binding.drink1Count.text = 0.toString()
            drink2.count = 0
            binding.drink2Count.text = 0.toString()
            drink3.count = 0
            binding.drink3Count.text = 0.toString()
        //Total Price Reset
            binding.totalPrice.text = 0.toString()
            bill = 0f
        }
    }

    /**
     * Diese Funktion addiert den Preis zur Rechnung
     */
    private fun addToBill(price: Float?) {
        if (price != null) {
            bill += price
            bill = round(bill * 100) / 100
        }
    }
}
