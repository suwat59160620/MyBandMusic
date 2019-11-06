package buu.informatics.s59160620.mybandmusic


import android.content.ActivityNotFoundException
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160620.mybandmusic.databinding.AboutFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<AboutFragmentBinding>(inflater,
            R.layout.about_fragment,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (menu != null) {
            if (inflater != null) {
                super.onCreateOptionsMenu(menu, inflater)
            }
        }
        inflater?.inflate(R.menu.shared, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareMenu -> onShare()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun onShare() {
        val shareIntent = ShareCompat.IntentBuilder.from(getActivity())
            .setText("เพลงที่อยากฟัง")
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {

        }
    }



}
