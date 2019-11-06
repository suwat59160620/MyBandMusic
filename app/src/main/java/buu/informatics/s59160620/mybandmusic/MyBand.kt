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
import buu.informatics.s59160620.mybandmusic.databinding.MyBandBinding

/**
 * A simple [Fragment] subclass.
 */
class MyBand : Fragment() {

    private lateinit var binding: MyBandBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.my_band, container, false)
        var bandMusicPage = arguments?.getString("BandMusic")
        binding.txtNamefBand.setText(bandMusicPage)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var bandMusicPage = arguments?.getString("BandMusic")
        (activity as AppCompatActivity).supportActionBar?.title = bandMusicPage
        ShowimgBand(bandMusicPage)
        Log.i("r", bandMusicPage)
        var brandSelected = bundleOf("RecordMusic" to bandMusicPage)
        binding.recordBtn.setOnClickListener { view: View? ->
            view?.findNavController()?.navigate(R.id.action_myBand_to_recordFragment, brandSelected)
        }
        binding.musicBtn.setOnClickListener { view: View? ->
            view?.findNavController()?.navigate(R.id.action_myBand_to_musicFragment, brandSelected)
        }
    }


    private fun ShowimgBand(bandMusic: String?){

        if(bandMusic == "Big Ass")
        {
            binding.imgBandband.setImageResource(R.drawable.bigass)
        }
        else if(bandMusic == "Bodyslam")
        {
            binding.imgBandband.setImageResource(R.drawable.bodyslam)
        }
        else if(bandMusic == "Lomosonic")
        {
            binding.imgBandband.setImageResource(R.drawable.lomosonic)
        }
        else if(bandMusic == "Retrospect")
        {
            binding.imgBandband.setImageResource(R.drawable.retrospect)
        }
        else if(bandMusic == "Sweet Mullet")
        {
            binding.imgBandband.setImageResource(R.drawable.sweet)
        }


    }


}
