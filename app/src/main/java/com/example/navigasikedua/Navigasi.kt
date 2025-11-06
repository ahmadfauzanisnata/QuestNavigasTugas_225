package com.example.navigasikedua


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasikedua.view.HalamanFormulir
import com.example.navigasikedua.view.HalamanList
import com.example.navigasikedua.view.HalamanSelamatDatang


enum class PengelolaHalaman {
    Home,
    List,
    Form,
}

@Composable
fun NavigasiAplikasi(
    navController: NavHostController = rememberNavController()
) 