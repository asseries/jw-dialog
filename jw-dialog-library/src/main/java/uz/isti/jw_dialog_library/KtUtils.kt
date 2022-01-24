package uz.isti.jw_dialog_library

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

object KtUtils {
        fun Context.showError(message: String){
            val dialog = JWAlertDialog(JWAlertType.ERROR, message)
            dialog.show((this as AppCompatActivity).supportFragmentManager, dialog.tag)
        }

        fun Context.showWarning(message: String){
            val dialog = JWAlertDialog(JWAlertType.WARNING, message)
            dialog.show((this as AppCompatActivity).supportFragmentManager, dialog.tag)
        }

        fun Context.showInfo(message: String){
            val dialog = JWAlertDialog(JWAlertType.INFO, message)
            dialog.show((this as AppCompatActivity).supportFragmentManager, dialog.tag)
        }

        fun Context.showSuccess(message: String){
            val dialog = JWAlertDialog(JWAlertType.SUCCESS, message)
            dialog.show((this as AppCompatActivity).supportFragmentManager, dialog.tag)
        }

        fun Context.showJWAlert(type: JWAlertType, message: String, callback: JSAlertDialogCallback? = null){
            val dialog = JWAlertDialog(type, message, callback)
            dialog.show((this as AppCompatActivity).supportFragmentManager, dialog.tag)
        }

        fun Context.showJWConfirm(message: String, listener: JWConfirmDialogListener? = null){
            val dialog = JWConfirmDialog(message, listener)
            dialog.show((this as AppCompatActivity).supportFragmentManager, dialog.tag)
        }
}
