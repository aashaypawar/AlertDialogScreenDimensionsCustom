package com.aashay.alertdialogone

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaring and initializing button from the layout
        val mButton = findViewById<Button>(R.id.button)

        // When button is clicked
        mButton.setOnClickListener {

            // Build an alert dialog, declare its attributes
            val mDialogBuilder = AlertDialog.Builder(this)
            mDialogBuilder.apply {
                setTitle("This is Title")
                setMessage("This is Message: \n\nWidth & Height set to 50% of app screen size")
                setPositiveButton("Positive Button", null)
                setNegativeButton("Negative Button", null)
            }

            // Create and show the dialog
            val mDialog = mDialogBuilder.create()
            mDialog.show()

            // Get the current app screen width and height
            val mDisplayMetrics = windowManager.currentWindowMetrics
            val mDisplayWidth = mDisplayMetrics.bounds.width()
            val mDisplayHeight = mDisplayMetrics.bounds.height()

            // Generate custom width and height and add to the dialog attributes
            val mLayoutParams = WindowManager.LayoutParams()
            mLayoutParams.width = (mDisplayWidth * 0.5f).toInt()
            mLayoutParams.height = (mDisplayHeight * 0.5f).toInt()
            mDialog.window?.attributes = mLayoutParams

        }
    }
}