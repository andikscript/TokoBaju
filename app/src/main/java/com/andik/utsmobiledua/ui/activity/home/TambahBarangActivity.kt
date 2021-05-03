package com.andik.utsmobiledua.ui.activity.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.andik.utsmobiledua.R
import com.andik.utsmobiledua.model.Barang
import com.andik.utsmobiledua.room.DatabaseDB
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.tambah_barang.*

class TambahBarangActivity : AppCompatActivity() {

    lateinit var myDb : DatabaseDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah_barang)

        myDb = DatabaseDB.getInstance(this)!!

        simpan.setOnClickListener {
            if (id_barang.text.toString().isEmpty()) {
                id_barang.error = "Kolom ID Barang tidak boleh kosong"
                id_barang.requestFocus()
            } else if (nama_barang.text.toString().isEmpty()) {
                nama_barang.error = "Kolom Nama Barang tidak boleh kosong"
                nama_barang.requestFocus()
            } else if (harga_barang.text.toString().isEmpty()) {
                harga_barang.error = "Kolom Harga Barang tidak boleh kosong"
                harga_barang.requestFocus()
            } else {
                val barang = Barang()
                barang.idBarang = id_barang.text.toString()
                barang.nama = nama_barang.text.toString()
                barang.harga = harga_barang.text.toString()
                simpan(barang)
            }
        }
    }

    private fun simpan(data : Barang) {
        CompositeDisposable().add(Observable.fromCallable { myDb.daoBarang().insert(data) }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                toast("Data Berhasil Tersimpan")
                onBackPressed()
            }
        )
    }

    private fun toast(string : String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}