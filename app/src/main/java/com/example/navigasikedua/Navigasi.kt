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
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name, // Mulai dari Halaman Selamat Datang
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(route = PengelolaHalaman.Home.name) {
                HalamanSelamatDatang(
                    onSubmitClicked = {

                        navController.navigate(PengelolaHalaman.List.name)
                    }
                )
            }


            composable(route = PengelolaHalaman.List.name) {
                HalamanList(
                    onBerandaClicked = {
                        navController.navigate(PengelolaHalaman.Home.name) {
                            popUpTo(PengelolaHalaman.Home.name) { inclusive = true }
                        }
                    },
                    onFormulirClicked = {

                        navController.navigate(PengelolaHalaman.Form.name)
                    }
                )
            }


            composable(route = PengelolaHalaman.Form.name) {
                HalamanFormulir(
                    onSubmitClicked = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
