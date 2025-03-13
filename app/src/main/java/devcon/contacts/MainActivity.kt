package devcon.contacts

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import devcon.learn.contacts.R

class MainActivity : AppCompatActivity() {

    private lateinit var etMail: EditText;
    private lateinit var etPhone: EditText;
    private lateinit var etName: EditText;
    private lateinit var btnSave: Button;
    private lateinit var btnCancel: Button;
    private lateinit var groupMoreBtn: Group
    private lateinit var groupMoreView: Group
    private lateinit var viewMore: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.et_name)
        etPhone = findViewById(R.id.et_phone)
        etMail = findViewById(R.id.et_mail)
        btnSave = findViewById(R.id.btn_save)
        btnCancel = findViewById(R.id.btn_cancel)
        groupMoreBtn = findViewById(R.id.group_more_btn)
        groupMoreView = findViewById(R.id.group_more_view)
        viewMore = findViewById(R.id.view_more)


        btnSave.setOnClickListener {
            if (isNameEmpty()) {
                showToast(resources.getString(R.string.toast_name_empty))
                showKeyboard(etName)
            } else if (isPhoneEmpty()) {
                showToast(resources.getString(R.string.toast_phone_empty))
                showKeyboard(etPhone)
            } else {
                showToast(resources.getString(R.string.toast_save))
            }
        }

        btnCancel.setOnClickListener {
            showToast(resources.getString(R.string.toast_cancel))
        }

        viewMore.setOnClickListener {
            groupMoreBtn.visibility = View.GONE
            groupMoreView.visibility = View.VISIBLE
        }
    }

    private fun isNameEmpty(): Boolean {
        return etName.text.isNullOrEmpty()
    }

    private fun isPhoneEmpty(): Boolean {
        return etPhone.text.isNullOrEmpty()
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun showKeyboard(focusEditText: EditText) {
        val inputMethodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        focusEditText.requestFocus()
        inputMethodManager.showSoftInput(focusEditText, InputMethodManager.SHOW_IMPLICIT)
    }
}
