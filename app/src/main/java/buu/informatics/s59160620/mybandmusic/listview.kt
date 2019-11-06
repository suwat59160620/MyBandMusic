package buu.informatics.s59160620.mybandmusic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class listview(var context: Context?, var type: ArrayList<listBandData>): BaseAdapter() {
    private class ViewHolder(row: View?){
        var txtNameBand: TextView
        var imgBand: ImageView

        init {
            this.txtNameBand = row?.findViewById(R.id.txt_name_band) as TextView
            this.imgBand = row?.findViewById(R.id.img_band) as ImageView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if(convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.listview_fragment,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var amusic:listBandData = getItem(position) as listBandData
        viewHolder.txtNameBand.text = amusic.name
        viewHolder.imgBand.setImageResource(amusic.image)
        return view as View

    }

    override fun getItem(position: Int): Any {
        return type.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return type.count();
    }
}
