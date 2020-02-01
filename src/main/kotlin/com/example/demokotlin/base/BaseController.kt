package com.example.demokotlin.base

import org.apache.logging.log4j.Logger
import java.io.StringReader
import com.google.gson.*
import com.google.gson.stream.JsonReader

open class BaseController {

    private var gson = Gson()


    fun convertResponseToJson(str: String, key: String?): Any? {
        val reader = JsonReader(StringReader(str))
        reader.isLenient = true
        var data: JsonElement? = null
        if (key != null) {
            data = JsonParser().parse(reader).asJsonObject.get(key)
        } else {
            data = JsonParser().parse(reader).asJsonObject
        }
        return data
    }

    fun <T> convertResponseToModel(str: String, key: String?, clazz: Class<T>): T {
        val data: Any
        return if (key != null) {
            data = convertResponseToJson(str, key) as JsonElement
            gson.fromJson(data, clazz)
        } else {
            data = convertResponseToJson(str, key) as JsonObject
            gson.fromJson(data, clazz)
        }
    }

    fun <T> convertResponseToModel(str: String, clazz: Class<T>): T {
        return gson.fromJson(str, clazz)
    }

    fun log(throwable: Throwable, logger: Logger) {
        val log = Utils().getStackTrace(throwable)
        logger.error(log)
        throwable.printStackTrace()
    }
}