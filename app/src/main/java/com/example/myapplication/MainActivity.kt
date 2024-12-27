package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color(0xFF5462A4))
                            .padding(8.dp)
                    ) {
                        Text("Welcome!", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("Number Guessing", color = Color(0xFF5462A4), fontSize = 24.sp)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("Game", color = Color(0xFF5462A4), fontSize = 24.sp)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            {
                                val intent = Intent(this@MainActivity, EasyPage::class.java)
                                startActivity(intent)
                            }, modifier = Modifier
                                .height(70.dp)
                                .width(210.dp),
                            colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFFA0E065),
                                disabledContainerColor = Color(0xFFA0E065),
                                disabledContentColor = Color.Black,

                                )
                        ) { Text("Easy", fontSize = 30.sp) }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            {
                                val intent = Intent(this@MainActivity, NormalPage::class.java)
                                startActivity(intent)
                            }, modifier = Modifier
                                .height(70.dp)
                                .width(210.dp),
                            colors = ButtonColors(
                                containerColor = Color(0xFF86C7DB),
                                contentColor = Color.Black,
                                disabledContainerColor = Color(0xFF86C7DB),
                                disabledContentColor = Color.Black,

                                )
                        ) { Text("Normal", fontSize = 30.sp) }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            {
                                val intent = Intent(this@MainActivity, HardPage::class.java)
                                startActivity(intent)
                            }, modifier = Modifier
                                .height(70.dp)
                                .width(210.dp),
                            colors = ButtonColors(
                                containerColor = Color(0xFFF1713E),
                                contentColor = Color.Black,
                                disabledContainerColor = Color(0xFFF1713E),
                                disabledContentColor = Color.Black,

                                )
                        ) { Text("Hard", fontSize = 30.sp) }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            {
                                val intent = Intent(this@MainActivity, MasterPage::class.java)
                                startActivity(intent)
                            }, modifier = Modifier
                                .height(70.dp)
                                .width(210.dp),
                            colors = ButtonColors(
                                containerColor = Color(0xFFD81C1C),
                                contentColor = Color.Black,
                                disabledContainerColor = Color(0xFFD81C1C),
                                disabledContentColor = Color.Black,

                                )
                        ) { Text("Master", fontSize = 30.sp) }
                    }
                    Spacer(modifier = Modifier.height(80.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            {
                                val intent=Intent(this@MainActivity,StatsPage::class.java)
                                startActivity(intent)
                            }, modifier = Modifier
                                .height(70.dp)
                                .width(210.dp),
                            colors = ButtonColors(
                                containerColor = Color(0xFFF8D9D9),
                                contentColor = Color.Black,
                                disabledContainerColor = Color(0xFFF8D9D9),
                                disabledContentColor = Color.Black,

                                )
                        ) { Text("Stats", fontSize = 30.sp) }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            {}, modifier = Modifier
                                .height(70.dp)
                                .width(210.dp),
                            colors = ButtonColors(
                                containerColor = Color(0xFFB8FFFB),
                                contentColor = Color.Black,
                                disabledContainerColor = Color(0xFFB8FFFB),
                                disabledContentColor = Color.Black,

                                )
                        ) { Text("About", fontSize = 30.sp) }
                    }
                }


            }

        }
    }
}

