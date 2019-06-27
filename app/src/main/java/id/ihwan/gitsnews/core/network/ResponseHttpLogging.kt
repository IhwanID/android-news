package id.ihwan.gitsnews.core.network

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.logging.HttpLoggingInterceptor

class ResponseHttpLogging : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        val logName = "OkHttp"
        if (!message.startsWith("{")) {
            Log.d(logName, message)
            return
        }
        try {
            val prettyPrintJson = GsonBuilder().setPrettyPrinting().create().toJson(JsonParser().parse(message))
            Log.d(logName, prettyPrintJson)
        } catch (m: JsonSyntaxException) {
            Log.d(logName, message)
        }

    }
}