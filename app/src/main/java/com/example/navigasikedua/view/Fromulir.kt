package com.example.navigasikedua.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanFormulir(
    onSubmitClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val listGender = listOf("Laki-laki", "Perempuan")
    val listStatus = listOf("Janda", "Lajang", "Duda")

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFD1C4E9), Color.White)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(24.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Formulir Pendaftaran",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF673AB7),
                    modifier = Modifier.padding(bottom = 20.dp)
                )


                LabeledOutlinedTextField("NAMA LENGKAP", "Isian nama lengkap", nama) { nama = it }
                Spacer(modifier = Modifier.height(16.dp))


                RadioGroup(
                    label = "JENIS KELAMIN",
                    options = listGender,
                    selectedOption = jenisKelamin,
                    onOptionSelected = { jenisKelamin = it }
                )
                Spacer(modifier = Modifier.height(16.dp))


                RadioGroup(
                    label = "STATUS PERKAWINAN",
                    options = listStatus,
                    selectedOption = status,
                    onOptionSelected = { status = it }
                )
                Spacer(modifier = Modifier.height(16.dp))


                LabeledOutlinedTextField("ALAMAT", "Alamat", alamat) { alamat = it }
                Spacer(modifier = Modifier.height(24.dp))


                Button(
                    onClick = onSubmitClicked,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text(text = "Submit", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}


@Composable
private fun LabeledOutlinedTextField(label: String, placeholder: String, value: String, onValueChange: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Text(text = label, fontWeight = FontWeight.Medium, fontSize = 14.sp, modifier = Modifier.padding(bottom = 4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
private fun RadioGroup(label: String, options: List<String>, selectedOption: String, onOptionSelected: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Text(text = label, fontWeight = FontWeight.Medium, fontSize = 14.sp, modifier = Modifier.padding(bottom = 4.dp))
        options.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .selectable(
                        selected = (selectedOption == item),
                        onClick = { onOptionSelected(item) }
                    )
                    .padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = (selectedOption == item),
                    onClick = { onOptionSelected(item) }
                )
                Text(text = item, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}