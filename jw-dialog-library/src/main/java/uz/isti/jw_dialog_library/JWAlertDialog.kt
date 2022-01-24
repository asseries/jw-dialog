package uz.isti.jw_dialog_library

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.jwalert_dialog.*

enum class JWAlertType {
    INFO,
    SUCCESS,
    WARNING,
    ERROR
}

interface JSAlertDialogCallback{
    fun onClickDismiss()
}

class JWAlertDialog(var type: JWAlertType, var message: String, var callback: JSAlertDialogCallback? = null) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.jwalert_dialog, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvMessage.text = message
        when(type){
            JWAlertType.INFO ->{
                animationView.setAnimation("info.json")
            }
            JWAlertType.SUCCESS ->{
                animationView.setAnimation("success_.json")
            }
            JWAlertType.WARNING ->{
                animationView.setAnimation("warning.json")
            }
            JWAlertType.ERROR ->{
                animationView.setAnimation("error.json")
            }

        }

        cardViewOk.setOnClickListener {
            dismiss()
        }
        animationView.playAnimation()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        callback?.onClickDismiss()
    }
}