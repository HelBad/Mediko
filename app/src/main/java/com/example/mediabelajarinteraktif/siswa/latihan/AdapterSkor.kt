package com.example.mediabelajarinteraktif.siswa.latihan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.model.Pilihan
import com.example.mediabelajarinteraktif.model.Soal
import kotlinx.android.synthetic.main.card_pembahasan.view.*

class AdapterSkor(private val listSoal: ArrayList<Soal>, private val listJawaban: Map<Int, Pilihan>) : RecyclerView.Adapter<AdapterSkor.ViewHolderPembahasan>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPembahasan {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_pembahasan, parent, false)
        return ViewHolderPembahasan(view)
    }

    override fun onBindViewHolder(holder: ViewHolderPembahasan, position: Int) {
        holder.bind(listSoal[position], listJawaban[position])
    }

    override fun getItemCount(): Int {
        return listSoal.size
    }

    inner class ViewHolderPembahasan(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(soal: Soal, jawaban: Pilihan?){
            var kunci : String ? = null
            soal.pilihan?.forEach {
                if(it.isBenar == 1) kunci = it.pilihan
            }

            if(jawaban?.isBenar == 1){
                itemView.a.text = "BENAR"
                itemView.a.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.holo_blue_bright))
            }
            else{
                itemView.a.text = "SALAH"
                itemView.a.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorRed))
            }

            itemView.namaNilai.text = soal.soal
            itemView.absenNilai.text = kunci
            itemView.kelasNilai.text = jawaban?.pilihan
        }
    }
}