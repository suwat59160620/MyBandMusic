package buu.informatics.s59160620.mybandmusic


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160620.mybandmusic.database.MusicDatabaseModels
import buu.informatics.s59160620.mybandmusic.databinding.FragmentRulesBinding

/**
 * A simple [Fragment] subclass.
 */
class rules : Fragment() {
    private lateinit var add:dataViewModel
    private lateinit var binding: FragmentRulesBinding
    var select = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rules, container, false)
        add = ViewModelProviders.of(this).get(dataViewModel::class.java)
        add.clear()
        selected()
    addMusic()
        return binding.root
    }

private fun addMusic (){
        binding.okey.setOnClickListener{
            if(binding.nameMusic.text.isEmpty() && binding.musicURL.text.isEmpty()){
                Toast.makeText(getActivity(), "กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_LONG).show()
            }
            else {
                add.insert(
                    MusicDatabaseModels(
                        0,
                        select,
                        binding.nameMusic.text.toString(),
                        binding.musicURL.text.toString()
                    )
                )
                view?.findNavController()
                    ?.navigate(R.id.action_rulesFragment_to_listFragment2)

            }
        }
    }

    private fun selected() {
        var list_of_items = arrayOf("Big Ass", "Bodyslam", "Lomosonic", "Retrospect","Sweet Mullet")
        val spinner = binding.nameBrand
        spinner?.adapter = activity?.applicationContext?.let {
            ArrayAdapter(
                it,
                R.layout.support_simple_spinner_dropdown_item,
                list_of_items
            )
        } as SpinnerAdapter
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val type = parent?.getItemAtPosition(position).toString()
                select = type
            }

        }
    }
}
