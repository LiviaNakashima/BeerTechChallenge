package br.com.desafio.wccfinalchallenge.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.desafio.wccfinalchallenge.R
import br.com.desafio.wccfinalchallenge.entity.Product
import com.bumptech.glide.Glide

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {
    var data = listOf<Product>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.product_item, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item.produto, item.descricao, item.preco, item.desconto, item.imagem)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        private val itemTitle = itemView.findViewById<TextView>(R.id.tv_product_name)
        private val itemDescription = itemView.findViewById<TextView>(R.id.tv_product_description)
        private val itemPrice = itemView.findViewById<TextView>(R.id.tv_product_price)
        private val itemImage = itemView.findViewById<ImageView>(R.id.imgview_product)

        fun bind(product: String, description: String, price: Double, discount:Boolean, url: String) {
            itemTitle.text = product
            itemDescription.text = description

            itemPrice.text = "R$ $price"

            if(discount){
                itemPrice.setTextColor(Color.parseColor("#0FB816"))
            }

            if(url.isNotEmpty()) {
                Glide.with(itemView.context)
                    .load(url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(itemImage)
            } else {
                Glide.with(itemView.context).clear(itemView)
                itemImage.setImageResource(R.drawable.ic_launcher_background)
            }
        }
    }

}