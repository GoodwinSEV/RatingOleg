package com.example.ratingoleg
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ratingoleg.ui.theme.Purple40
import com.example.ratingoleg.ui.theme.RatingOlegTheme
import kotlin.random.Random
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RatingOlegTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var randomNumber = remember { Random.nextInt(1, 10) }
    var result by remember { mutableStateOf(4) }
    var inputtext by remember { mutableStateOf("") }

    val stringResource = when(result) {
        1 -> R.string.app

        2 -> R.string.app2
        3 -> R.string.app3
        4 -> R.string.app22
        else -> R.string.app22
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()
            .height(70.dp)
            .background(color = Purple40)) {
            Text(
                text = "RatingOleg",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 20.dp, top = 15.dp)
            )
        }

        Row(modifier = Modifier.fillMaxWidth()
            .padding(top = 250.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(stringResource))
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = inputtext,
            onValueChange = { inputtext = it },
        )
        Button(onClick = {
            val number = inputtext.toIntOrNull()
            if (number == null) {
                result = 4
            } else if (number < randomNumber) {
                result = 1
            } else if (number > randomNumber) {
                result = 2
            } else {
                result = 3
                randomNumber = Random.nextInt(1, 10)}
        },
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 18.dp, end = 18.dp)
        ) {
            Text(text = "ПРОВЕРИТЬ ЧИСЛО")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RatingOlegTheme {
        Greeting()
    }
}