package com.example.mediabelajarinteraktif.guru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mediabelajarinteraktif.OnItemActionCallback
import com.example.mediabelajarinteraktif.R
import com.example.mediabelajarinteraktif.model.Soal
import kotlinx.android.synthetic.main.card_soal.view.*

class AdapterSoal(val listSoal: ArrayList<Soal>) : RecyclerView.Adapter<AdapterSoal.ViewHolderSoal>() {

    private var onItemEditCallback: OnItemActionCallback? = null
    private var onItemDeleteCallback: OnItemActionCallback? = null

    fun setOnItemEditCallback(onItemEditCallback: OnItemActionCallback) {
        this.onItemEditCallback = onItemEditCallback
    }

    fun setOnItemDeleteCallback(onItemDeleteCallback: OnItemActionCallback) {
        this.onItemDeleteCallback = onItemDeleteCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSoal {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_soal, parent, false)
        return ViewHolderSoal(view)
    }

    override fun onBindViewHolder(holder: ViewHolderSoal, position: Int) {
        holder.bind(listSoal[position])
    }

    override fun getItemCount(): Int {
        return listSoal.size
    }

    inner class ViewHolderSoal(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(soal: Soal){
            itemView.soal.text = soal.soal
            soal.pilihan?.forEach { pil ->
                if(pil.isBenar == 1) itemView.kunci.text = pil.pilihan
            }

            itemView.btn_edit_soal.setOnClickListener { onItemEditCallback?.onItemAction(soal) }
            itemView.btn_delete_soal.setOnClickListener { onItemDeleteCallback?.onItemAction(soal) }
        }
    }
}