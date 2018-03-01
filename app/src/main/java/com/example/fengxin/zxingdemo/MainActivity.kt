package com.example.fengxin.zxingdemo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.zxing.activity.CaptureActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_scan.setOnClickListener {
            var intent = Intent(this,CaptureActivity::class.java)
            startActivityForResult(intent, REQ_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CODE) {
            if (data != null) {

                var result = data.getStringExtra(CaptureActivity.SCAN_QRCODE_RESULT)
                edt_content.setText(result)
                Log.e("MainActivity : ", result)
            }
        }

    }

    companion object {
        private val REQUEST_CODE_SCAN = 111
        private var REQ_CODE = 1028
    }

}
