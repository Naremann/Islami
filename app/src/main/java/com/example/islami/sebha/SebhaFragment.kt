package com.example.islami.sebha

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.islami.R


class SebhaFragment : Fragment() {
    lateinit var sebhaBody: ImageView
    lateinit var PraiseCounterBtn: Button
    private lateinit var PraiseTypeBtn: Button
    private var PraiseCounter = 0
    private var typeOfPraiseKey = 0
    var rotationValue = 10f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PraiseCounterBtn = view.findViewById(R.id.tasbihCounter_btn)
        PraiseTypeBtn = view.findViewById(R.id.tasbihType_btn)
        sebhaBody = view.findViewById(R.id.sebha_body_img)
        PraiseTypeBtn.setOnClickListener {
            PraiseCounter++
            typeOfPraiseKey++
            rotateSebhaBody()
            PraiseCounterBtn.text = PraiseCounter.toString()

            if (typeOfPraiseKey == 34) {
                PraiseCounter = 0
                typeOfPraiseKey++
                PraiseCounter++
                PraiseCounterBtn.text = PraiseCounter.toString()
                val praise = getString(R.string.tasbeeh_thanks)
                PraiseTypeBtn.text = praise

            }
            if (typeOfPraiseKey == 68) {
                PraiseCounter = 0
                typeOfPraiseKey++
                PraiseCounter++
                PraiseCounterBtn.text = PraiseCounter.toString()
                val tasbeehThanks = getString(R.string.tasbih_takbeer)
                PraiseTypeBtn.text = tasbeehThanks
            }
            if (typeOfPraiseKey == 102) {
                typeOfPraiseKey = 0
                PraiseCounter = 0
                typeOfPraiseKey++
                PraiseCounter++
                PraiseCounterBtn.text = PraiseCounter.toString()

                val str = getString(R.string.praise)
                PraiseTypeBtn.text = str

            }
        }


    }

    private fun rotateSebhaBody() {
        sebhaBody.animate().rotation(rotationValue).start()
        rotationValue += 10f
    }
}