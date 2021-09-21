package com.mnp.inspectioncheck.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mnp.inspectioncheck.R

class HomeViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_view_kerusakan, parent, false)) {

    private var imgView: ImageView? = null
    private var itemName: TextView? = null
    private var itemLokasi: TextView? = null
    private var itemKerusakan: TextView? = null
    private var itemTanggal: TextView? = null
    private var itemPetugasNama: TextView? = null

    init {
        imgView = itemView.findViewById(R.id.imgView)
        itemName = itemView.findViewById(R.id.item_nama)
        itemLokasi = itemView.findViewById(R.id.item_lokasi)
        itemKerusakan = itemView.findViewById(R.id.item_kerusakan)
        itemTanggal = itemView.findViewById(R.id.item_tanggal)
        itemPetugasNama = itemView.findViewById(R.id.item_petugas_nama)
    }
    fun bind (data : Kerusakan){
        imgView?.setImageResource(data.imgView)
        itemName?.text = data.itemNama
        itemLokasi?.text = data.itemLokasi
        itemKerusakan?.text = data.itemKerusakan
        itemTanggal?.text = data.itemTanggal
        itemPetugasNama?.text = data.itemPetugasNama
    }

}