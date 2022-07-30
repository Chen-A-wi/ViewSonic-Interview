package com.example.spacex.ui.launch_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spacex.R
import com.example.spacex.databinding.FragmentLaunchDetailBinding

class LaunchDetailFragment : Fragment() {
    private lateinit var binding: FragmentLaunchDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_launch_detail, container, false)
    }
}