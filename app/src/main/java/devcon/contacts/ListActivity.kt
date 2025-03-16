package devcon.contacts

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import devcon.learn.contacts.R

class ListActivity : AppCompatActivity() {

    private lateinit var btnAdd: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initView()
        initData()
    }

    private fun initData() {
        val getData = ProfileSharedPreferences.getAllProfiles()

        // 데이터 확인용 log
        Log.d("boris920308", "getData = ${getData}")
    }

    private fun initView() {
        btnAdd = findViewById(R.id.btn_add)

        initOnClickListener()
    }

    private fun initOnClickListener() {
        btnAdd.setOnClickListener {
            Utils.navigateToActivity(this, MainActivity::class.java)
        }
    }
}