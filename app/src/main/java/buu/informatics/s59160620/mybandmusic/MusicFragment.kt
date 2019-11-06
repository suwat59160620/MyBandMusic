package buu.informatics.s59160620.mybandmusic


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160620.mybandmusic.databinding.FragmentMusicBinding
import kotlinx.android.synthetic.main.fragment_music.*

/**
 * A simple [Fragment] subclass.
 */
class MusicFragment : Fragment() {
    private lateinit var getAll:dataViewModel
    private lateinit var binding: FragmentMusicBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_music, container, false)
        getAll = ViewModelProviders.of(this).get(dataViewModel::class.java)

        var bandMusicPage = arguments?.getString("RecordMusic")

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var bandMusicPage = arguments?.getString("RecordMusic")
        var checkRecord = "เพลง " + bandMusicPage

        var arrayModel : ArrayList<listDataMusic> = ShowTextRecord(bandMusicPage)

        listview_music.adapter = listMusic(getActivity()?.applicationContext, arrayModel);


        (activity as AppCompatActivity).supportActionBar?.title = checkRecord

        listview_music.setOnItemClickListener { parent, view, position, id ->
                Log.d("positionArr",arrayModel[position].url)
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(arrayModel[position].url))
            startActivity(i)
            Toast.makeText(activity, arrayModel[position].name, Toast.LENGTH_SHORT).show()
        }

    }

    private fun ShowTextRecord(bandMusic: String?): ArrayList<listDataMusic> {
        var music = HashMap<String, Int>();
        var arraymusic : ArrayList<listDataMusic> = ArrayList()
        music["Big Ass"] = R.string.listMusicBigAss
        music["Bodyslam"] = R.string.listMusicBodyslam
        music["Lomosonic"] = R.string.listMusicLomosonic
        music["Retrospect"] = R.string.listMusicRetrospect
        music["Sweet Mullet"] = R.string.listMusicSweetMullet
        var count = 0
        if(bandMusic == "Big Ass")
        {
            arraymusic.add(listDataMusic("บินเข้ากองไฟ : ", "https://www.youtube.com/watch?v=Q9HcrgpHCiw"))
            arraymusic.add(listDataMusic("แดนเนรมิต : ", "https://www.youtube.com/watch?v=fJKasTangEM"))
            arraymusic.add(listDataMusic("ส่งท้ายคนเก่า ต้อนรับคนใหม่ : ", "https://www.youtube.com/watch?v=1BJeo0qnqjc"))
            arraymusic.add(listDataMusic("ดีแต่ปาก : ", "https://www.youtube.com/watch?v=l7r3nPuO-wc"))
            arraymusic.add(listDataMusic("ข้าน้อยสมควรตาย : ", "https://www.youtube.com/watch?v=1BJeo0qnqjc"))
        }
        else if(bandMusic == "Bodyslam")
        {
            arraymusic.add(listDataMusic("เรือเล็กควรออกจากฝั่ง : ", "https://www.youtube.com/watch?v=6RF1Zz5xcNg"))
            arraymusic.add(listDataMusic("dharmajāti (ดัม-มะ-ชา-ติ) : ", "https://www.youtube.com/watch?v=egC2EP3YHB4"))
            arraymusic.add(listDataMusic("คนมีตังค์ : ", "https://www.youtube.com/watch?v=xxSoQqxTHbQ"))
            arraymusic.add(listDataMusic("ยาพิษ : ", "https://www.youtube.com/watch?v=tn7_CFkr6Oo"))
            arraymusic.add(listDataMusic("ความรัก : ", "https://www.youtube.com/watch?v=XZp9BOjvD7o"))
        }
        else if(bandMusic == "Lomosonic")
        {
            arraymusic.add(listDataMusic("กลัวว่าความคิดถึงของฉันจะทำร้ายเธอ (AFRAID) : ", "https://www.youtube.com/watch?v=zQhT8_RgZRg"))
            arraymusic.add(listDataMusic("ขอ (WARM EYES) : ", "https://www.youtube.com/watch?v=tUuqWFExZgY"))
            arraymusic.add(listDataMusic("ถึงเวลา.... (Wake) : ", "https://www.youtube.com/watch?v=apljdslXJks"))
            arraymusic.add(listDataMusic("เก็บไว้ (ECHO) : ", "https://www.youtube.com/watch?v=-Bl3T6SCMt4"))
            arraymusic.add(listDataMusic("เพราะความรักมันไม่เลือกเวลาเกิด : ", "https://www.youtube.com/watch?v=lxL5N6FZQew"))
        }
        else if(bandMusic == "Retrospect")
        {
            arraymusic.add(listDataMusic("เจ็บกว่าคือฉัน : ", "https://www.youtube.com/watch?v=81gu4Sa63To"))
            arraymusic.add(listDataMusic("เหนื่อยไหมหัวใจ : ", "https://www.youtube.com/watch?v=3NnJYUDrFH4"))
            arraymusic.add(listDataMusic("สุดที่รัก : ", "https://www.youtube.com/watch?v=a__R_dumrMc"))
            arraymusic.add(listDataMusic("ปล่อยฉัน : ", "https://www.youtube.com/watch?v=AJykOIlS3pM"))
            arraymusic.add(listDataMusic("เหงายิ่งกว่าเหงา : ", "https://www.youtube.com/watch?v=lxL5N6FZQew"))
        }
        else if(bandMusic == "Sweet Mullet")
        {
            arraymusic.add(listDataMusic("สภาวะหัวใจล้มเหลวเฉียบพลัน : ", "https://www.youtube.com/watch?v=u6Bs3MDjuMs"))
            arraymusic.add(listDataMusic("ภาพติดตา : ", "https://www.youtube.com/watch?v=AY_r7zEPHek"))
            arraymusic.add(listDataMusic("เจ็บทุกลมหายใจ : ", "https://www.youtube.com/watch?v=a46kjMegdfE"))
            arraymusic.add(listDataMusic("ฝากเลี้ยง : ", "https://www.youtube.com/watch?v=MgoGEJvd4Sg"))
            arraymusic.add(listDataMusic("พลังแสงอาทิตย์ : ", "https://www.youtube.com/watch?v=iacMeRlFw1I"))
        }else{
            arraymusic.add(listDataMusic("ไม่พบข้อมูล : ", "."))
        }

        getAll.getAll.observe(this, Observer { t ->
            t.forEach {

                Log.i("musiclog", "${it.urlMusic} ")

                if (it.nameBand == "Big Ass") {
                    if (bandMusic == "Big Ass") {
                        arraymusic.add(listDataMusic("${it.nameMusic}", "${it.urlMusic}"))
                    }

                }
                if (it.nameBand == "Bodyslam") {
                    if (bandMusic == "Bodyslam") {
                        arraymusic.add(listDataMusic("${it.nameMusic}", "${it.urlMusic}"))
                    }

                }
                if (it.nameBand == "Lomosonic") {
                    if (bandMusic == "Lomosonic") {
                        arraymusic.add(listDataMusic("${it.nameMusic}", "${it.urlMusic}"))
                    }

                }
                if (it.nameBand == "Retrospect") {
                    if (bandMusic == "Retrospect") {
                        arraymusic.add(listDataMusic("${it.nameMusic}", "${it.urlMusic}"))
                    }

                }
                if (it.nameBand == "Sweet Mullet") {
                    if (bandMusic == "Sweet Mullet") {
                        arraymusic.add(listDataMusic("${it.nameMusic}", "${it.urlMusic}"))
                    }

                }
                count++
            }
            if (count == t.size) {
                listview_music.adapter =
                    listMusic(getActivity()?.applicationContext, arraymusic);
            }
        })
        return arraymusic


    }

}
