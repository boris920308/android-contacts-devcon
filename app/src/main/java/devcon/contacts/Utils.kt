package devcon.contacts

import android.content.Context
import android.content.Intent
import android.os.Bundle

object Utils {

    fun navigateToActivity(context: Context, destinationClass: Class<*>) {
        val intent = Intent(context, destinationClass)
        context.startActivity(intent)
    }
}
