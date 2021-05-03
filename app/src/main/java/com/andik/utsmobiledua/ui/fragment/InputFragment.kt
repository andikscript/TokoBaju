package com.andik.utsmobiledua.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.andik.utsmobiledua.R
import com.andik.utsmobiledua.model.Barang
import com.andik.utsmobiledua.room.DatabaseDB
import com.andik.utsmobiledua.ui.activity.home.TambahBarangActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.tambah_barang.*

class InputFragment : Fragment() {
    lateinit var btnTambah: Button

    lateinit var myDb : DatabaseDB

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_input, container, false)
        init(root)
        mainButton()
        return root
    }

    private fun mainButton() {
        btnTambah.setOnClickListener {
            startActivity(Intent(requireActivity(), TambahBarangActivity::class.java))
        }
    }

    private fun init(view: View) {
        btnTambah = view.findViewById(R.id.tambah_barang)
    }
}