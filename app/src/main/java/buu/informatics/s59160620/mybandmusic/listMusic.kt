package buu.informatics.s59160620.mybandmusic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class listMusic(var context: Context?, var type: ArrayList<listDataMusic>): BaseAdapter() {
    private class ViewHolder(row: View?){
        var name: TextView
        var url: TextView

        init {
            this.name = row?.findViewById(R.id.txt_name_music) as TextView
            this.url = row?.findViewById(R.id.text_url) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if(convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.fragment_list_music,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var music:listDataMusic = getItem(position) as listDataMusic
        viewHolder.name.text = music.name
        viewHolder.url.text = music.url
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