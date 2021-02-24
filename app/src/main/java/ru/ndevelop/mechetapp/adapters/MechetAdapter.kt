package ru.ndevelop.mechetapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import ru.ndevelop.mechetapp.R
import ru.ndevelop.mechetapp.ui.tools.MechetType

class MechetAdapter(val mechetClickListener: OnMechetClickListener):
        RecyclerView.Adapter<MechetAdapter.SingleViewHolder>()  {
    private var items: Array<MechetType> = MechetType.values()

    inner class SingleViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView),
            View.OnClickListener {
        private val tvMechetName: TextView = convertView.findViewById(R.id.tv_name)
        private val tvMechetYear: TextView = convertView.findViewById(R.id.tv_year)
        private val clMain:ConstraintLayout = convertView.findViewById(R.id.cl_main)


        fun bind(item: MechetType) {
            tvMechetName.text = item.mechetName
            clMain.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            when(v){
                clMain ->{
                    mechetClickListener.onMechetClicked(adapterPosition)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val convertView = inflater.inflate(R.layout.single_mechet_list, parent, false)
        return SingleViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: SingleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
interface OnMechetClickListener{
    fun onMechetClicked(mechetId:Int)
}

