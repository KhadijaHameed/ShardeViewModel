package com.example.shaedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.shaedviewmodel.databinding.FragPoundsBinding


class PoundFragment : Fragment() {
    lateinit var model: SharedViewModel
    private lateinit var binding: FragPoundsBinding

    var pounds = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragPoundsBinding.inflate(inflater, container, false)

        binding.radio01.setOnClickListener {
            binding.radio01.isChecked = true
            binding.radio02.isChecked = false
            binding.radio03.isChecked = false
            binding.radio04.isChecked = false
            pounds = "2"
        }

        binding.radio02.setOnClickListener {
            binding.radio02.isChecked = true
            binding.radio01.isChecked = false
            binding.radio03.isChecked = false
            binding.radio04.isChecked = false
            pounds = "2.5"
        }
        binding.radio03.setOnClickListener {
            binding.radio01.isChecked = false
            binding.radio02.isChecked = false
            binding.radio03.isChecked = true
            binding.radio04.isChecked = false
            pounds = "3"
        }

        binding.radio04.setOnClickListener {
            binding.radio01.isChecked = false
            binding.radio02.isChecked = false
            binding.radio03.isChecked = false
            binding.radio04.isChecked = true
            pounds = "4"
        }

        return binding.root
    }


    //CHOOSE POUNDS FRAGMENT
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.btnNext.setOnClickListener {
            model.sendPounds(pounds) // <<-- pounds variable has value of selected radioButton's item like "3"
           binding.first.visibility = GONE
            binding.secondFragment.visibility = VISIBLE

            addFrag()
        }
    }

    fun addFrag(){
        // Create new fragment and transaction
        // Create new fragment and transaction
        val newFragment: Fragment = LocationsFragment()
        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
        transaction.add(R.id.secondFragment_, newFragment)
        transaction.addToBackStack(null)

// Commit the transaction

// Commit the transaction
        transaction.commit()
    }


}