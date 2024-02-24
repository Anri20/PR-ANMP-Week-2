package com.example.pranmpweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class MainFragment : Fragment() {
    private lateinit var view: View;
    private lateinit var txtQuestion: TextView;
    private lateinit var btnSubmit: Button;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false)

        txtQuestion = view.findViewById(R.id.txtQuestion)
        btnSubmit = view.findViewById(R.id.btnSubmit)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSubmit.setOnClickListener {
//            val answerTrue = MainFragmentDirections.actionAnswerTrue()
//            Navigation.findNavController(it).navigate(answerTrue)
            val gameover = MainFragmentDirections.actionResultFragment()
            Navigation.findNavController(it).navigate(gameover)
        }
    }
}