package buu.informatics.s59160620.mybandmusic


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160620.mybandmusic.databinding.RecordFragmentBinding


/**
 * A simple [Fragment] subclass.
 */
class recordFragment : Fragment() {

    private lateinit var binding: RecordFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.record_fragment, container, false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var bandMusicPage = arguments?.getString("RecordMusic")
        var checkRecord = "ประวัติวงดนตรี " + bandMusicPage
        (activity as AppCompatActivity).supportActionBar?.title = checkRecord
        ShowTextRecord(bandMusicPage)
        }
    private fun ShowTextRecord(bandMusic: String?){
        var recore = HashMap<String, Int>();
        recore["Big Ass"] = R.string.recordBigAss
        recore["Bodyslam"] = R.string.recordBodyslam
        recore["Lomosonic"] = R.string.recordLomosonic
        recore["Retrospect"] = R.string.recordRetrospect
        recore["Sweet Mullet"] = R.string.recordSweetMullet

        if(bandMusic == "Big Ass")
        {
            binding.txtRecord.text = resources.getText(recore.get(bandMusic)!!)
        }
        else if(bandMusic == "Bodyslam")
        {
            binding.txtRecord.text = resources.getText(recore.get(bandMusic)!!)
        }
        else if(bandMusic == "Lomosonic")
        {
            binding.txtRecord.text = resources.getText(recore.get(bandMusic)!!)
        }
        else if(bandMusic == "Retrospect")
        {
            binding.txtRecord.text = resources.getText(recore.get(bandMusic)!!)
        }
        else if(bandMusic == "Sweet Mullet")
        {
            binding.txtRecord.text = resources.getText(recore.get(bandMusic)!!)
        }else{
            binding.txtRecord.setText("ไม่พบข้อมูล")

        }


    }
    }



