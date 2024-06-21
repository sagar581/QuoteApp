package com.example.quoteapp.models

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManger {

    var data = emptyArray<Quote>()
    enum class pages{
        Listing,
        Detailed
    }

    var curQuote : Quote? = null
    val state = mutableStateOf(false)
    val curPage = mutableStateOf(pages.Listing)
    fun LoadItems(context: Context){
        val inputsteam = context.assets.open("quotes.json")
        val size = inputsteam.available()
        val buffer = ByteArray(size)
        inputsteam.read(buffer)
        inputsteam.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        state.value=true

    }

    fun switchPages(quote: Quote?){
        if (curPage.value==pages.Listing){
            curQuote=quote
            curPage.value= pages.Detailed
        }
        else
            curPage.value=pages.Listing
    }
}