package ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager

import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearSmoothScroller
import com.example.homework_recyclerview.Currency
import com.example.homework_recyclerview.R
import com.google.android.material.textfield.TextInputEditText
import java.util.*


class AddCurrencyFragment(var adapter: Adapter)  : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newCurrencyType = view.findViewById<TextInputEditText>(R.id.newCurrencyType).text
        val newCurrencyText = view.findViewById<TextInputEditText>(R.id.newCurrencyText).text

        val addFromFragment = view.findViewById<Button>(R.id.addFromFragment)
        addFromFragment.setOnClickListener {
            adapter.addNewItem(Currency(newCurrencyText.toString(), newCurrencyType.toString(), R.drawable.image_1_5))

            parentFragmentManager.popBackStack()
        }
    }
}