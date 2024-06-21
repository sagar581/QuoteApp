package com.example.quoteapp.screens

import android.graphics.drawable.Icon
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quoteapp.models.DataManger
import com.example.quoteapp.models.Quote



@Composable
fun QuoteListItem(quote: Quote, onClick: (quote:Quote) -> Unit) {
    Card(
        //elevation = 4.dp,
        modifier = Modifier
            .clickable { onClick(quote) }
            .padding(8.dp)

    ) {
        Row (
            modifier = Modifier.padding(16.dp)
            )
        {
            Image(
                imageVector = Icons.Filled.Close,
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                contentDescription ="Quote",
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180F)
                    .background(Color.Black)
            )

            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(1f))
            {
                Text(text =quote.quoteText,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp)

                )
                Box(modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth(0.4f)
                    .height(1.dp)
                )

                Text(text = quote.quoteAuthor,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top =4.dp )
                )

            }

        }

    }

}


@Composable
fun QuoteDetail(quote: Quote) {


    BackHandler {
        DataManger.switchPages(null)
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFA87A7A),
                        Color(0xFFECE6E6)
                    )
                )
            )){

        Card(
            //elevation = 4.dp,
            modifier = Modifier.padding(8.dp),


            ) {
            Row (
                modifier = Modifier.padding(16.dp)
            )
            {
                Image(
                    imageVector = Icons.Filled.Close,
                    colorFilter = ColorFilter.tint(Color.White),
                    alignment = Alignment.TopStart,
                    contentDescription ="Quote",
                    modifier = Modifier
                        .size(40.dp)
                        .rotate(180F)
                        .background(Color.Black)
                )

                Spacer(modifier = Modifier.padding(4.dp))
                Column(modifier = Modifier.weight(1f))
                {
                    Text(text =quote.quoteText,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp)

                    )
                    Box(modifier = Modifier
                        .background(Color.Black)
                        .fillMaxWidth(0.4f)
                        .height(1.dp)
                    )

                    Text(text = quote.quoteAuthor,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(top =4.dp )
                    )

                }

            }

        }
    }


}
