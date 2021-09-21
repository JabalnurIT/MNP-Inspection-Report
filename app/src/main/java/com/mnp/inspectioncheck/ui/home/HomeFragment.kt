package com.mnp.inspectioncheck.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.mnp.inspectioncheck.R
import com.mnp.inspectioncheck.databinding.FragmentHomeBinding
import com.mnp.inspectioncheck.databinding.RecyclerViewKerusakanBinding
import com.mnp.inspectioncheck.ui.gallery.InspeksiFragment

class HomeFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HomeAdapter
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.inspeksiBt.setOnClickListener {
            Toast.makeText(context,"Harusnya Pindah",Toast.LENGTH_SHORT).show()
        }
        init()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return root
    }

    private fun init() {
        recyclerView = binding.recylcerView

        var data = ArrayList<Kerusakan>()

        data.add(Kerusakan(
            R.drawable.a,
            "Saklar",
            "Gate",
            "Ada semut yang bersarang dan memutus kabel",
            "1/3/2021",
            "Muhammad Sabri"))
        data.add(Kerusakan(
            R.drawable.b,
            "Tiang",
            "Lampu Sorot",
            "Ada semut yang bersarang dan memutus kabel",
            "1/3/2021",
            "Muhammad Sabri"))
        data.add(Kerusakan(
            R.drawable.c,
            "Push Button",
            "Reefer Station",
            "Rusak Terkena Palu",
            "1/3/2021",
            "Muhammad Sabri"))
        data.add(Kerusakan(
            R.drawable.d,
            "Pipa",
            "Pump House Lapangan",
            "Ada Kucing Mati di Dalam Pipa",
            "1/3/2021",
            "Muhammad Sabri"))
        data.add(Kerusakan(
            R.drawable.e,
            "Kondisi Ban",
            "Mobil Tangki",
            "Meletus",
            "1/3/2021",
            "Muhammad Sabri"))
        data.add(Kerusakan(
            R.drawable.f,
            "Saklar",
            "Gate",
            "Ada semut yang bersarang dan memutus kabel",
            "1/3/2021",
            "Muhammad Sabri"))
        data.add(Kerusakan(
            R.drawable.g,
            "Instalasi Kabel",
            "Jembatan Timbang",
            "Digigit Tikus",
            "1/3/2021",
            "Muhammad Sabri"))
        data.add(Kerusakan(
            R.drawable.h,
            "Tombol Lift dan Lampu",
            "kantor Operasional",
            "Rusak terkena air minuman",
            "1/3/2021",
            "Muhammad Sabri"))
        data.add(Kerusakan(
            R.drawable.i,
            "Spion",
            "Mobil Kebakaran Kebakaran",
            "Rusak Terkena Tabrakan Motor",
            "1/3/2021",
            "Muhammad Sabri"))
        data.add(Kerusakan(
            R.drawable.j,
            "Instalasi Kabel",
            "Fasilitas Penerangan Jalan dan Bangunan",
            "Putus Digigit Tikus",
            "1/3/2021",
            "Muhammad Sabri"))
        adapter = HomeAdapter(data)
        if(adapter != null)Toast.makeText(context,"berhasil",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}