package com.csc415.twoactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.TextView
import android.widget.EditText
import android.content.Intent
import android.util.Log

const val EXTRA_REPLY = "com.csc415.twoactivities.extra.REPLY"

class SecondActivity : AppCompatActivity()
{
	private lateinit var mReply: EditText
	private val logTag = SecondActivity::class.java.simpleName

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_second)
		findViewById<TextView>(R.id.text_message).text = intent.getStringExtra(EXTRA_MESSAGE);
		mReply = findViewById(R.id.editText_second);
	}

	fun returnReply(view: View)
	{
		val replyIntent = Intent()
		replyIntent.putExtra(EXTRA_REPLY, mReply.text.toString())
		setResult(RESULT_OK, replyIntent)
		Log.d(logTag, "End SecondActivity");
		finish()
	}
}