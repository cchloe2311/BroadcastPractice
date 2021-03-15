package com.example.broadcastpractice

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    //private var myReceiver : MyReceiver? = null
    private var myReceiver = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        registerReceiver()

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver()
    }

    /**
     * 수신자의 등록 및 등록 취소 위치에 유의해야 합니다.
     *
     * 예를 들어 활동의 컨텍스트를 사용하여 onCreate(Bundle)에 수신자를 등록했으면 활동 컨텍스트에서 수신자가 유출되지 않도록 onDestroy()에서 수신자를 등록 취소해야 합니다.
     * onResume()에 수신자를 등록했으면 onPause()에서 수신자를 등록 취소하여 수신자가 여러 번 등록되지 않도록 해야 합니다(일시중지되었을 때 브로드캐스트를 수신하지 않으려면).
     * 이렇게 하면 불필요한 시스템 오버헤드를 줄일 수 있습니다.
     * 그리고 onSaveInstanceState(Bundle)에서 등록을 취소해서는 안 됩니다. 사용자가 기록 스택으로 되돌아가면 이 메서드가 호출되지 않기 때문입니다.
     */

    private fun registerReceiver() {
        // myReceiver ?: MyReceiver()

        val intentFilter = IntentFilter().apply {
            addAction(AIRPLANE_ACTION)
            addAction(MY_ACTION)
        }

        this.registerReceiver(myReceiver, intentFilter)
    }

    private fun unregisterReceiver() {
        this.unregisterReceiver(myReceiver)

        // myReceiver = null
    }

    fun sendBroadcast(v: View) {
        val intent = Intent(MY_ACTION)
        sendBroadcast(intent)
    }
}
