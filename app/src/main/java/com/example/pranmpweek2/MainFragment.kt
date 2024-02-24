package com.example.pranmpweek2

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText

class MainFragment : Fragment() {
    private lateinit var view: View
    private lateinit var txtQuestion: TextView
    private lateinit var btnSubmit: Button
    private lateinit var txtAnswer: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false)

        txtQuestion = view.findViewById(R.id.txtQuestion)
        btnSubmit = view.findViewById(R.id.btnSubmit)
        txtAnswer = view.findViewById(R.id.txtAnswer)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var finalScore = 0
        val pointScore = 1

//        Random Number Generator
        val randomVal1 = (0..100).random()
        val randomVal2 = (0..100).random()

        txtQuestion.text = "$randomVal1 + $randomVal2"

//        calculating answer
        var answer = randomVal1 + randomVal2

        btnSubmit.setOnClickListener {
//            if answer false
            if (txtAnswer.text.toString() != answer.toString()) {
                var action = MainFragmentDirections.actionResultFragment(finalScore)
                Navigation.findNavController(it).navigate(action)
            }

            finalScore += pointScore

//            Random Number Generator
            val randomVal1 = (0..100).random()
            val randomVal2 = (0..100).random()

            txtQuestion.text = "$randomVal1 + $randomVal2"

//            calculating answer
            answer = randomVal1 + randomVal2
            txtAnswer.setText("")
        }
    }
}