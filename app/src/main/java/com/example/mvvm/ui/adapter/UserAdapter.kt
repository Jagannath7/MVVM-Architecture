package com.example.mvvm.ui.adapter

import android.hardware.usb.UsbRequest
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data.models.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(val data: List<User>): RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        = UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(data[position])
    }
}

class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(item: User) = with(itemView){
        userNameView.text = item.login
        Picasso.get().load(item.avatarUrl).into(userImgView)
    }

}
