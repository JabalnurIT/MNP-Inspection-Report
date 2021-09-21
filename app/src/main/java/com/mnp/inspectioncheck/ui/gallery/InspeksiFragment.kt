package com.mnp.inspectioncheck.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mnp.inspectioncheck.databinding.FragmentInspeksiBinding

class InspeksiFragment : Fragment() {

    private lateinit var inspeksiViewModel: InspeksiViewModel
    private var _binding: FragmentInspeksiBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inspeksiViewModel =
            ViewModelProvider(this).get(InspeksiViewModel::class.java)

        _binding = FragmentInspeksiBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        inspeksiViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}