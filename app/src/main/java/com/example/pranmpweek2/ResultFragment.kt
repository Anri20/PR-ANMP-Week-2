package com.example.pranmpweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class ResultFragment : Fragment() {
    private lateinit var view: View;
    private lateinit var btnBack: Button;
    private lateinit var txtScore: TextView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_result, container, false)

        btnBack = view.findViewById(R.id.btnBack)
        txtScore = view.findViewById(R.id.txtScore)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let{
            val finalScore = ResultFragmentArgs.fromBundle(requireArguments()).finalScore
            txtScore.text = "Your Score is $finalScore"
        }

        btnBack.setOnClickListener {
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}