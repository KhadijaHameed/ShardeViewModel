package com.example.shaedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shaedviewmodel.databinding.FragSummaryBinding

class SummaryFragment  : Fragment() {

    lateinit var model: SharedViewModel
    private lateinit var binding: FragSummaryBinding

    var totalSummaryDetail = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragSummaryBinding.inflate(inflater, container, false)

        return binding.root
    }

    //ORDER SUMMARY FRAGMENT
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        model.flavor.observe(viewLifecycleOwner, Observer {
            totalSummaryDetail += "Flavor:\n $it\n\n"
            binding.textViewReceiver.text =  totalSummaryDetail
        })

        model.pounds.observe(viewLifecycleOwner, Observer {
            totalSummaryDetail += "Pound:\n $it\n\n"
            binding.textViewReceiver.text = totalSummaryDetail
        })

        model.location.observe(viewLifecycleOwner, Observer {
            totalSummaryDetail += "Location:\n $it\n\n"
            binding.textViewReceiver.text = totalSummaryDetail
        })


    }
}