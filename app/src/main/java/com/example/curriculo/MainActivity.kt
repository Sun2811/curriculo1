package com.example.curriculo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurriculumVitaeApp()
        }
    }
}

@Composable
fun CurriculumVitaeApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "perfil") {
        composable("perfil") { PerfilScreen(navController) }
        composable("experiencia") { ExperienciaScreen() }

    }
}

@Composable
fun PerfilScreen(navController: NavHostController) {
    BackgroundImage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Nome: Antônio Vital", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Objetivo: Desejo um estágio na área de Ciência da Computação para desenvolver minhas competências em programação e criação de software, além de obter conhecimento prático na profissão.", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate("experiencia") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE))
            ) {
                Text(text = "Ir para Experiência", color = Color.White)
            }
        }
    }
}

@Composable
fun ExperienciaScreen() {
    BackgroundImage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "EXPERIÊNCIA PROFISSIONAL", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "• Echo Prime (Sócio)\nComo co-fundador de uma empresa de kits de carnes, lidero a equipe e as vendas, identificando oportunidades de mercado e garantindo um excelente atendimento aos clientes.\n")
            Text(text = "• Flamboyant Loja (Sócio)\nComo gestor de uma loja feminina de varejo, lidero a equipe, identifico tendências de moda e garanto um excelente atendimento ao cliente.\n")
            Text(text = "• Martins Calçados (Sócio)\nNa qualidade de líder em uma empresa de atacado de calçados e roupas, destaco-me na condução de vendas e na comunicação eficaz com os lojistas.\n")
        }
    }
}

@Composable
fun BackgroundImage(content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.foto1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        content()
    }
}
