package com.andik.utsmobiledua.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andik.utsmobiledua.R
import com.andik.utsmobiledua.adapter.AdapterBarang
import com.andik.utsmobiledua.model.Barang
import com.andik.utsmobiledua.room.DatabaseDB
import com.andik.utsmobiledua.ui.activity.home.TambahBarangActivity
import java.util.ArrayList

class HomeFragment : Fragment() {
    lateinit var tvStatus: TextView
    lateinit var rvBarang: RecyclerView
    lateinit var myDb: DatabaseDB

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        init(root)
        myDb = DatabaseDB.getInstance(requireActivity())!!
        displayKelas()
        return root
    }

    private fun init(view: View) {
        tvStatus = view.findViewById(R.id.status)
        rvBarang = view.findViewById(R.id.rv_barang)
    }

    private fun displayKelas() {
        val listBarang = myDb.daoBarang().getAll()

        if (listBarang.isEmpty()) {
            tvStatus.visibility = View.VISIBLE
        } else {
            tvStatus.visibility = View.GONE
        }

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvBarang.adapter =
            AdapterBarang(listBarang as ArrayList<Barang>)
        rvBarang.layoutManager = layoutManager
    }

    override fun onResume() {
        displayKelas()
        super.onResume()
    }
}