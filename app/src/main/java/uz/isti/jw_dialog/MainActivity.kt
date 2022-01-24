package uz.isti.jw_dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import uz.isti.jw_dialog_library.KtUtils.showError
import uz.isti.jw_dialog_library.KtUtils.showSuccess
import uz.isti.jw_dialog_library.KtUtils.showWarning

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowSuccess.setOnClickListener {
            showSuccess("Muofaqqiyatli bajarildi")
        }
        btnShowWarning.setOnClickListener {
            showWarning("Ogohlantiruvchi xabar")
        }
        btnShowError.setOnClickListener {
            showError("Xatolik mavjud")
        }
    }
}