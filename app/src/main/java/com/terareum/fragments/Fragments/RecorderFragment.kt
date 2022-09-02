package com.terareum.fragments.Fragments

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.terareum.fragments.R
import com.terareum.fragments.databinding.RecorderFragmentBinding


class RecorderFragment : Fragment() {
    private lateinit var binding: RecorderFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecorderFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.click.setOnClickListener {
//         val bundle = Bundle()
//            bundle.putString("key1","check")
//            val frag = NotesFragment()
//            frag.arguments = bundle
//            parentFragmentManager.beginTransaction().replace(R.id.frame_layout, frag).commit()
//        }

        binding.imageview.setImageBitmap(textAsBitmap("hi helloooo", 50f, R.color.black))
    }

    private fun textAsBitmap(text: String, textSize: Float, textColor: Int): Bitmap? {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.textSize = textSize
        paint.color = textColor
        paint.textAlign = Paint.Align.LEFT
        val baseline = -paint.ascent() // ascent() is negative
        val width = (paint.measureText(text) + 0.5f).toInt() // round
        val height = (baseline + paint.descent() + 0.5f).toInt()
        val image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(image)
        canvas.drawText(text, 0f, baseline, paint)
        return image
    }
}