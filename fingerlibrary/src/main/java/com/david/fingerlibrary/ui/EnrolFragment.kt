package com.david.fingerlibrary.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.david.fingerlibrary.R
import timber.log.Timber


class EnrolFragment : Fragment() {
    /**
     * 需要显示的内容
     * 1.本次采集到的图片分数
     * 2. 采集进度
     * 3.采集回调的图片
     * 4.采集的总进度（根据fugue enrol 值判断）
     * 5.采集的图片要保存在相应的目录（根据选择的store的目录配置）
     *
     */

    companion object {
        fun newInstance() = EnrolFragment()
    }

    private lateinit var viewModel: EnrolViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.enrol_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(EnrolViewModel::class.java)
        Timber.i(arguments!!.getString("finger"))
    }

}
