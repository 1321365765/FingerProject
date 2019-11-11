package com.david.fingerlibrary.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.david.fingerlibrary.R
import kotlinx.android.synthetic.main.enrol_fragment.*
import timber.log.Timber


class EnrolFragment : Fragment() {

    private var x1 = 0f
    private var x2 = 0f
    private var y1 = 0f
    private var y2 = 0f


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_tips.text = "请将${arguments!!.getString("finger")}按在指纹采集区域"
        lottie_finger.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                lottie_finger.playAnimation()
                x1 = event.x
                y1 = event.y


            }
            if (event.action == MotionEvent.ACTION_MOVE) {
                //当手指移动的时候
                x2 = event.x
                y2 = event.y
                if (y1 - y2 > 50) {
                    Toast.makeText(activity, "向上滑", Toast.LENGTH_SHORT).show()
                } else if (y2 - y1 > 50) {
                    Toast.makeText(activity, "向下滑", Toast.LENGTH_SHORT).show()
                } else if (x1 - x2 > 50) {
                    Toast.makeText(activity, "向左滑", Toast.LENGTH_SHORT).show()
                } else if (x2 - x1 > 50) {
                    Toast.makeText(activity, "向右滑", Toast.LENGTH_SHORT).show()
                }
            }

            if (event.action == MotionEvent.ACTION_UP) {
                lottie_finger.pauseAnimation()
                lottie_finger.progress = 0f
            }
            return@setOnTouchListener true
        }
    }

}
