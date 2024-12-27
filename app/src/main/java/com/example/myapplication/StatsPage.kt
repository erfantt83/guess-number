package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class StatsPage : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val num= remember {
                    mutableStateOf(0)
                }
               Column(modifier = Modifier.fillMaxSize()) {
                   CenterAlignedTopAppBar(colors = TopAppBarColors(
                       containerColor = Color(0xFFF8D9D9),
                       scrolledContainerColor = Color.Black,
                       navigationIconContentColor = Color.Black,
                       titleContentColor = Color.Black,
                       actionIconContentColor = Color.Black
                   ), title = { Text(text = "Stats", fontWeight = FontWeight.Bold, fontSize = 24.sp) },
                       navigationIcon =  {
                           IconButton({
                               val intent=Intent(this@StatsPage,MainActivity::class.java)
                               startActivity(intent)
                           }) {
                               Icon(
                                   painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                                   contentDescription = ""
                               )
                           }

                       }
                   )
                   Row(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
                       Text("Best stats on ", fontSize = 32.sp)
                       Spacer(modifier = Modifier.width(10.dp))
                       Text("Easy:", fontSize = 36.sp, color = Color(0xFFA0E065))
                   }
                   Spacer(modifier = Modifier.height(80.dp))
                   Row(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
                       Text("Best stats on ", fontSize = 32.sp)
                       Spacer(modifier = Modifier.width(10.dp))
                       Text("Normal:", fontSize = 36.sp, color = Color(0xFF86C7DB))
                   }
                   Spacer(modifier = Modifier.height(80.dp))
                   Row(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
                       Text("Best stats on ", fontSize = 32.sp)
                       Spacer(modifier = Modifier.width(10.dp))
                       Text("Hard:", fontSize = 36.sp, color = Color(0xFFF1713E))
                   }
                   Spacer(modifier = Modifier.height(80.dp))
                   Row(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
                       Text("Best stats on ", fontSize = 32.sp)
                       Spacer(modifier = Modifier.width(10.dp))
                       Text("Master:", fontSize = 36.sp, color = Color(0xFFD81C1C))
                   }



               }
            }
        }
    }
}

