package com.aibles.roomexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.aibles.roomexample.databinding.ItemEmailBinding
import com.aibles.roomexample.entity.Email

class EmailAdapter(
    private val lifecycleOwner: LifecycleOwner
): RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {
    val emailList = listOf(Email("a", "This is spam mail"))

    class EmailViewHolder(
        private val binding: ItemEmailBinding,
        private val lifecycleOwner: LifecycleOwner
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(email: Email){
            binding.email = email
            binding.lifecycleOwner = lifecycleOwner
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEmailBinding.inflate(layoutInflater, parent, false)
        return EmailViewHolder(binding, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.bind(email)
    }

    override fun getItemCount(): Int = emailList.size
}