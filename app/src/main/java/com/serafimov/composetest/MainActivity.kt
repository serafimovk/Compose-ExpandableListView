package com.serafimov.composetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.tooling.preview.Preview
import androidx.ui.core.*
import androidx.ui.material.*
import androidx.ui.text.TextStyle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { createScreen(getMockContent()) }
    }

}

@Composable
private fun createScreen(owners: List<Owner>) {
    MaterialTheme(
        MaterialColors(
            primary = Color.Black,
            secondary = Color.DarkGray,
            background = Color.White
        ),
        MaterialTypography(
            h6 = TextStyle(color = Color(0xff0d1626), fontSize = 18.sp),
            subtitle1 = TextStyle(color = Color(0xff6e7785), fontSize = 15.sp),
            subtitle2 = TextStyle(color = Color(0xff6e7785), fontSize = 15.sp)
        )
    ) {
        AccountOwnersList(owners = owners)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    createScreen(getMockContent())
}
