package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteapp.models.DataManger
import com.example.quoteapp.screens.QuoteDetail
import com.example.quoteapp.screens.QuoteList
import com.example.quoteapp.ui.theme.QuoteAppTheme
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val job = CoroutineScope(Dispatchers.IO).launch{
            DataManger.LoadItems(applicationContext)

        }
        setContent {
            //App()
            tt()
        }
    }
}
@Composable
fun tt(){
    val temp = rememberSaveable{mutableStateOf(0) }

    Button(onClick = { temp.value++ }) {
        Text(text = "${temp.value}")
    }
}

@Composable
fun App() {
    if (DataManger.state.value) {
        if (DataManger.curPage.value == DataManger.pages.Listing)
        {
            QuoteList(data = DataManger.data) {
                DataManger.switchPages(it)
            }
        }
        else DataManger.curQuote?.let { QuoteDetail(quote = it) }
    }
    
}
