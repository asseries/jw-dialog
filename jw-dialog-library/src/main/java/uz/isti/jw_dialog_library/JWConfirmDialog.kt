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
import kotlinx.android.synthetic.main.jwconfirm_dialog.*

interface JWConfirmDialogListener{
    fun onClickYes()
    fun onClickNo()
}

class JWConfirmDialog(var message: String, var listener: JWConfirmDialogListener? = null) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.jwconfirm_dialog, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvMessage.text = message

        cardViewNo.setOnClickListener {
            listener?.onClickNo()
            dismiss()
        }

        cardViewYes.setOnClickListener {
            listener?.onClickYes()
            dismiss()
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        listener?.onClickNo()
    }
}