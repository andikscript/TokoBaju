package com.andik.utsmobiledua.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andik.utsmobiledua.R
import com.andik.utsmobiledua.model.Barang
import java.util.ArrayList

class AdapterBarang(var data : ArrayList<Barang>) : RecyclerView.Adapter<AdapterBarang.Holder>() {

    class Holder(view : View) : RecyclerView.ViewHolder(view) {
        val tvNama = view.findViewById<TextView>(R.id.tv_barang)
        val tvHarga = view.findViewById<TextView>(R.id.tv_harga)
        val layout = view.findViewById<LinearLayout>(R.id.layout)
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_barang, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.tvNama.text = a.nama
        holder.tvHarga.text = a.harga
    }

    interface Listeners {
        fun onDeleteClicked(barang: Barang)
        fun onEditClicked(barang: Barang)
    }
}


// com.andik.utsmobiledua