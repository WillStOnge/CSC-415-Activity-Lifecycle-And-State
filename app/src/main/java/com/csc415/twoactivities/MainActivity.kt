package com.csc415.twoactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent
import android.widget.EditText
import android.widget.TextView

const val EXTRA_MESSAGE = "com.csc415.twoactivities.extra.MESSAGE"
const val TEXT_REQUEST = 1

class MainActivity : AppCompatActivity()
{
	private val logTag = MainActivity::class.java.simpleName
	private lateinit var mMessageEditText: EditText
	private lateinit var mReplyHeadTextView: TextView
	private lateinit var mReplyTextView: TextView

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		mMessageEditText = findViewById(R.id.editText_main)
		mReplyHeadTextView = findViewById(R.id.text_header_reply)
		mReplyTextView = findViewById(R.id.text_message_reply)
		Log.d(logTag, "-------")
		Log.d(logTag, "onCreate")

		if (savedInstanceState != null)
		{
			if (savedInstanceState.getBoolean("reply_visible"))
			{
				mReplyHeadTextView.visibility = View.VISIBLE
				mReplyTextView.text = savedInstanceState.getString("reply_text")
				mReplyTextView.visibility = View.VISIBLE
			}
		}
	}

	override fun onStart()
	{
		super.onStart()
		Log.d(logTag, "onStart")
	}

	override fun onRestart()
	{
		super.onRestart()
		Log.d(logTag, "onRestart")
	}

	override fun onResume()
	{
		super.onResume()
		Log.d(logTag, "onResume")
	}

	override fun onPause()
	{
		super.onPause()
		Log.d(logTag, "onPause")
	}

	override fun onStop()
	{
		super.onStop()
		Log.d(logTag, "onStop")
	}

	override fun onDestroy()
	{
		super.onDestroy()
		Log.d(logTag, "onDestroy")
	}

	override fun onSaveInstanceState(outState: Bundle)
	{
		super.onSaveInstanceState(outState)

		if (mReplyHeadTextView.visibility == View.VISIBLE)
		{
			outState.putBoolean("reply_visible", true)
			outState.putString("reply_text", mReplyTextView.text.toString())
		}
	}


	fun launchSecondActivity(view: View)
	{
		Log.d(logTag, "Button clicked!");
		val intent = Intent(this, SecondActivity::class.java)
		intent.putExtra(EXTRA_MESSAGE, mMessageEditText.text.toString());
		startActivityForResult(intent, TEXT_REQUEST)
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
	{
		super.onActivityResult(requestCode, resultCode, data)
		if (requestCode == TEXT_REQUEST)
		{
			if (resultCode == RESULT_OK)
			{
				mReplyHeadTextView.visibility = View.VISIBLE
				mReplyTextView.text = data!!.getStringExtra(EXTRA_REPLY)
				mReplyTextView.visibility = View.VISIBLE
			}
		}
	}
}