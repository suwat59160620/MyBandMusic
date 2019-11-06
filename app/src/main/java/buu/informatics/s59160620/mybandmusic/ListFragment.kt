package buu.informatics.s59160620.mybandmusic


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160620.mybandmusic.databinding.ListFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var binding: ListFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false)

        var array: ArrayList<listBandData> = setListBand()
        binding.listView.adapter = listview(getActivity()?.applicationContext, array);

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            var brandSelected = bundleOf("BandMusic" to array[position].name)
            view.findNavController()
                .navigate(R.id.action_listFragment2_to_myBand,brandSelected)
        }


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun setListBand(): ArrayList<listBandData> {
        var array: ArrayList<listBandData> = ArrayList()
        array.add(listBandData("Big Ass", R.drawable.bigass));
        array.add(listBandData("Bodyslam", R.drawable.bodyslam));
        array.add(listBandData("Lomosonic", R.drawable.lomosonic));
        array.add(listBandData("Retrospect", R.drawable.retrospect));
        array.add(listBandData("Sweet Mullet", R.drawable.sweet));
        return array

    }


}
