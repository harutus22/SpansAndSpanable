package com.example.spansandspanable

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.*
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initColorText()

        initClickableText()

        changeStyleOfString()

    }

    private fun initColorText(){
        val text = "I want THIS and THIS to be colored"

        val ss = SpannableString(text) //Immutable string
        val ssb = SpannableStringBuilder(text) //Mutable string

//        ssb.append("and this to be appended")

        val fcsRed = ForegroundColorSpan(Color.RED) //choosing text color
        val fcsGreen = ForegroundColorSpan(Color.GREEN) //choosing text color

        val bcYellow = BackgroundColorSpan(Color.YELLOW) //choosing text background color

        ss.setSpan(fcsRed, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) //setting text color
        ss.setSpan(fcsGreen, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) //setting text color
        ss.setSpan(bcYellow, 27, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) //setting text background color

        text_view.text = ss
    }

    private fun initClickableText(){
        val text = "I want THIS and THIS be clickable"
        val ss = SpannableString(text)

        val clickableSpan1 = object : ClickableSpan(){
            override fun onClick(widget: View) {
                Toast.makeText(this@MainActivity, "One", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.BLUE
                ds.isUnderlineText = false
            }
        }

        val clickableSpan2 = object : ClickableSpan(){
            override fun onClick(widget: View) {
                Toast.makeText(this@MainActivity, "Two", Toast.LENGTH_SHORT).show()
            }

        }

        ss.setSpan(clickableSpan1, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(clickableSpan2, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        clickable_text.text = ss
        text_view.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun changeStyleOfString(){
        val text = "BOLD and ITALIC and BOLD_ITALIC and UNDERLINE and STRIKE-THROUGH"

        val ss = SpannableString(text)

        val boldSpan = StyleSpan(Typeface.BOLD)
        val italicSpan = StyleSpan(Typeface.ITALIC)
        val boldItalicSpan = StyleSpan(Typeface.BOLD_ITALIC)
        val underlineSpan = UnderlineSpan()
        val strikeThroughSpan = StrikethroughSpan()

        ss.setSpan(boldSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(italicSpan, 9, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(boldItalicSpan, 20, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(underlineSpan, 36, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(strikeThroughSpan, 50, 64, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}
