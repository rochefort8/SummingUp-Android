package com.rochefort10.summingup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val logTag = MainActivity::class.java.simpleName
    private var classifier: Classifier? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        classifier = Classifier(this)

        fingerPaint1.setOnClickListener{
            if(classifier == null){
                Log.e(logTag, "onDetectClick(): Classifier is not initialized")
            } else if(fingerPaint1.isEmpty){
                Toast.makeText(this, "Please write a digit in the box above.", Toast.LENGTH_LONG).show()
            } else {
                var image = fingerPaint1.exportToBitmap(classifier!!.imgWidth, classifier!!.imgHeight)
                var result = classifier!!.classify(image)

                indexText1.text = result.first.toString()
//                resultText.text = "%.3f".format(result.second * 100.0) + "%"
            }
        }

        clearButton1.setOnClickListener {
            fingerPaint1.clear()
            indexText1.text = ""
//            resultText.text = "0%"
        }

        fingerPaint2.setOnClickListener{
            if(classifier == null){
                Log.e(logTag, "onDetectClick(): Classifier is not initialized")
            } else if(fingerPaint2.isEmpty){
                Toast.makeText(this, "Please write a digit in the box above.", Toast.LENGTH_LONG).show()
            } else {
                var image = fingerPaint2.exportToBitmap(classifier!!.imgWidth, classifier!!.imgHeight)
                var result = classifier!!.classify(image)

                indexText2.text = result.first.toString()
//                resultText.text = "%.3f".format(result.second * 100.0) + "%"
            }
        }

        clearButton2.setOnClickListener {
            fingerPaint2.clear()
            indexText2.text = ""
//            resultText.text = "0%"
        }
    }
}