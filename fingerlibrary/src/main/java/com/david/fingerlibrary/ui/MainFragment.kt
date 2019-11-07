package com.david.fingerlibrary.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItems

import com.david.fingerlibrary.R
import com.david.fingerlibrary.databinding.FingerMainFragmentBinding
import java.util.*

class MainFragment : Fragment() {
    lateinit var mBinding: FingerMainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.finger_main_fragment, container, false)
        mBinding.viewModel = viewModel
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.liveData.observe(this, Observer {

            MaterialDialog(activity!!)
                .title(text = "温馨提示")
                .message(text = "emmmmmm")
                .neutralButton(text = "enrol (00/20) "){
                    findNavController().navigate(R.id.action_mainFragment_to_enrolFragment, null)
                }
                .negativeButton(text = "verify (00/20) "){
                    findNavController().navigate(R.id.action_mainFragment_to_verifyFragment, null)
                }
                .show()
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}
