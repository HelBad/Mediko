package com.example.mediabelajarinteraktif.guru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.model.User
import kotlinx.android.synthetic.main.card_nilai.view.*

class AdapterNilai(val listNilai: ArrayList<User>) : RecyclerView.Adapter<AdapterNilai.ViewHolderNilai>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNilai {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_nilai,parent,false)
        return ViewHolderNilai(view)
    }

    override fun onBindViewHolder(holder: ViewHolderNilai, position: Int) {
        holder.bind(listNilai[position])
    }

    override fun getItemCount(): Int {
        return listNilai.size
    }

    inner class ViewHolderNilai(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.namaNilai.text = user.nama
            itemView.absenNilai.text = user.noAbsen.toString()
            itemView.kelasNilai.text = user.kelas
            itemView.hasilNilai.text = user.nilai.toString()
        }
    }
}