package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.random.Random

class NormalPage : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val a: Int
            val random = Random(1000)
            a = random.nextInt(1000)
            MyApplicationTheme {
                val attempts = remember {
                    mutableStateOf(0)
                }
                val sign = remember {
                    mutableStateOf(0)
                }
                val number = remember {
                    mutableStateOf("")
                }
                val result = remember {
                    mutableStateOf("Guess the number(Between 0 and 1000)")
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CenterAlignedTopAppBar(colors = TopAppBarColors(
                        containerColor = Color(0xFF86C7DB),
                        scrolledContainerColor = Color.Black,
                        navigationIconContentColor = Color.Black,
                        titleContentColor = Color.Black,
                        actionIconContentColor = Color.Black
                    ), title = { Text(text = "Normal", fontWeight = FontWeight.Bold, fontSize = 24.sp) },
                        navigationIcon =  {
                            IconButton({
                                val intent=Intent(this@NormalPage,MainActivity::class.java)
                                startActivity(intent)
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                                    contentDescription = ""
                                )
                            }

                        }
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.4f)
                            .padding(16.dp)
                            .clip(RoundedCornerShape(24.dp))
                            .background(color = Color(0xFFBDECFA)),
                        contentAlignment = Alignment.Center,
                    ) {
                        if (sign.value == 1) {
                            Text(number.value, fontSize = 64.sp)
                        } else if (sign.value == 2) {
                            Text(number.value, fontSize = 64.sp)
                        } else if (sign.value == 3) {
                            Text(number.value, fontSize = 64.sp)
                        } else if (sign.value == 4) {
                            Text(number.value, fontSize = 64.sp)
                        } else if (sign.value == 5) {
                            Text(number.value, fontSize = 64.sp)
                        } else if (sign.value == 6) {
                            Text(number.value, fontSize = 64.sp)
                        } else if (sign.value == 7) {
                            Text(number.value, fontSize = 64.sp)
                        } else if (sign.value == 8) {
                            Text(number.value, fontSize = 64.sp)
                        } else if (sign.value == 9) {
                            Text(number.value, fontSize = 64.sp)
                        } else if (sign.value == 0) {
                            Text(number.value, fontSize = 64.sp)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.925f)
                                .fillMaxHeight(0.1f)
                                .background(color = Color(0xFFBDECFA)),
                            contentAlignment = Alignment.Center

                        ) {
                            Text(result.value)
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp)
                    ) {
                        Text(
                            "Attempts:" + attempts.value.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            {
                                if (number.value.isEmpty()) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Please enter your number",
                                        Toast.LENGTH_SHORT,
                                    ).show()
                                } else {
                                    if (number.value.toInt() > 0 && number.value.toInt() < 1000) {
                                        attempts.value++
                                        if (number.value.toInt() > a) {
                                            result.value =
                                                "Your guess is greater than the desired number"
                                            number.value = ""
                                        } else if (number.value.toInt() < a) {
                                            result.value =
                                                "Your guess is smaller than the desired number"
                                            number.value = ""
                                        } else if (number.value.toInt() == a) {
                                            result.value = "Your guess is correct"
                                            attempts.value=0
                                        }
                                    } else {
                                        Toast.makeText(
                                            applicationContext,
                                            "Number must be between 0 and 1000",
                                            Toast.LENGTH_SHORT,
                                        ).show()
                                    }
                                }

                            }, modifier = Modifier
                                .weight(1f)
                                .padding(10.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF00FF37),
                                disabledContainerColor = Color(0xFF00FF37),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("Submit", fontSize = 32.sp, color = Color.White)
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Button(
                            {
                                sign.value = 1
                                number.value += "1"
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF0087E7),
                                disabledContainerColor = Color(0xFF0087E7),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("1", fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            {
                                sign.value = 2
                                number.value += "2"
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF0087E7),
                                disabledContainerColor = Color(0xFF0087E7),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("2", fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            {
                                sign.value = 3
                                number.value += "3"
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF0087E7),
                                disabledContainerColor = Color(0xFF0087E7),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("3", fontSize = 20.sp, color = Color.White)
                        }

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Button(
                            {
                                sign.value = 4
                                number.value += "4"
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF0087E7),
                                disabledContainerColor = Color(0xFF0087E7),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("4", fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            {
                                sign.value = 5
                                number.value += "5"
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF0087E7),
                                disabledContainerColor = Color(0xFF0087E7),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("5", fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            {
                                sign.value = 6
                                number.value += "6"
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF0087E7),
                                disabledContainerColor = Color(0xFF0087E7),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("6", fontSize = 20.sp, color = Color.White)
                        }

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Button(
                            {
                                sign.value = 7
                                number.value += "7"
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF0087E7),
                                disabledContainerColor = Color(0xFF0087E7),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("7", fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            {
                                sign.value = 8
                                number.value += "8"
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF0087E7),
                                disabledContainerColor = Color(0xFF0087E7),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("8", fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            {
                                sign.value = 9
                                number.value += "9"
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF0087E7),
                                disabledContainerColor = Color(0xFF0087E7),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("9", fontSize = 20.sp, color = Color.White)
                        }

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Button(
                            {
                                number.value = ""
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFFFF0000),
                                disabledContainerColor = Color(0xFFFF0000),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("Delete", fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            {
                                sign.value = 0
                                number.value += "0"
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFF0087E7),
                                disabledContainerColor = Color(0xFF0087E7),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("0", fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            {
                               val intent=Intent(this@NormalPage,NormalPage::class.java)
                                startActivity(intent)
                            }, modifier = Modifier
                                .weight(1f)
                                .padding(4.dp), colors = ButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color(0xFFFFA837),
                                disabledContainerColor = Color(0xFFFFA837),
                                disabledContentColor = Color.Black,

                                )
                        ) {
                            Text("Reset", fontSize = 20.sp, color = Color.White)
                        }

                    }


                }

            }
        }
    }
}

