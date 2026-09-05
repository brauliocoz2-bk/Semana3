package dev.braulio.esan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braulio.esan.ui.theme.Semana3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            HelloComposeForm2()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloComposeForm(){
    var name  by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = {Text("ESAN APP")})
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(paddingValues = padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        )  {
            Text("Bienvenidos al curso de DAM")
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = {Text("Nombre")}
            )
            OutlinedTextField(
                value = birthDate,
                onValueChange = {birthDate = it},
                label = {Text("Fecha de nacimiento")}
            )
            Button(
                onClick = {},
                enabled = name.isNotEmpty() && birthDate.isNotEmpty()
            ){
                Text("Enviar")
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloComposeForm2(){

    var talla by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var imc by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("IMC") })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(paddingValues = padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            Text("Bienvenidos al IMC")

            OutlinedTextField(
                value = talla,
                onValueChange = { talla = it },
                label = { Text("Talla (cm)") }
            )

            OutlinedTextField(
                value = peso,
                onValueChange = { peso = it },
                label = { Text("Peso (kg)") }
            )

            Button(
                onClick = {

                    val tallaDouble = talla.toDoubleOrNull()
                    val pesoDouble = peso.toDoubleOrNull()

                    if (tallaDouble != null && pesoDouble != null && tallaDouble > 0) {

                        val resultado = pesoDouble / (tallaDouble * tallaDouble)

                        imc = String.format("%.2f", resultado)
                    }
                },
                enabled = talla.isNotEmpty() && peso.isNotEmpty()
            ) {
                Text("Calcular")
            }

            if (imc.isNotEmpty()) {
                Text(
                    text = "Tu IMC es: $imc"
                )
            }
        }
    }
}
