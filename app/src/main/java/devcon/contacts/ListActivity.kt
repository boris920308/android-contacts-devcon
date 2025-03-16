package devcon.contacts

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import devcon.learn.contacts.R

class ListActivity : AppCompatActivity() {

    private lateinit var btnAdd: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initView()
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