package com.example.barberleomx.ui.screens.barberdetail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R

@Composable
fun BarberDetailScreen(
    barberName: String,
    navController: NavController
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    var showAvatarDialog by remember { mutableStateOf(false) }

    val tabs = listOf("Servicios", "Ubicación")
    val context = LocalContext.current

    Scaffold { padding ->

        Column(modifier = Modifier.fillMaxSize()) {

            // 🔵 PORTADA + AVATAR
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.barber),
                    contentDescription = "Portada",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Image(
                    painter = painterResource(id = R.drawable.leofoto),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(110.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 55.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(4.dp)
                        .clickable { showAvatarDialog = true },
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            // Nombre
            Text(
                text = barberName,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 🔗 REDES SOCIALES
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                IconButton(onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/share/181N6aGPoF/?mibextid=wwXIfr")
                    )
                    context.startActivity(intent)
                }) {
                    Icon(Icons.Default.Facebook, contentDescription = "Facebook")
                }

                IconButton(onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/barberxleomx_?igsh=bGtqMXFzNm04a3I3")
                    )
                    context.startActivity(intent)
                }) {
                    Icon(Icons.Default.PhotoCamera, contentDescription = "Instagram")
                }

                IconButton(onClick = {
                    val intent = Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("https://l.facebook.com/l.php?u=https%3A%2F%2Fapi.whatsapp.com%2Fsend%3Fphone%3D%252B525560472789%26fbclid%3DIwZXh0bgNhZW0CMTAAYnJpZBExN1VIMDZOU014OHB1dUxjNnNydGMGYXBwX2lkEDIyMjAzOTE3ODgyMDA4OTIAAR7LYdBhymywvX8v15b_QpXFfsWkyhbhpp4eOio2Hq8wAMzlBi7aUS22Cqh61w_aem_JeBgOqKj-tKRVrGUNJAIJA&h=AT34J79ad2hFzEDhYyr7rRim0Bpo8rwhoMiRcpNoL7WFvFi_D1rPDrmkNEG0BCLorjFPdjWd4g4Dphn-RGtLwRrPANvIOG0NIFy2NN72eodRs_gLBwpOEBIOxMsbewARe8wG3E5tusnvPp9GdpsFNw")
                    )
                    context.startActivity(intent)
                }) {
                    Icon(Icons.Default.Call, contentDescription = "Teléfono")
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Tabs
            TabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title) }
                    )
                }
            }

            when (selectedTab) {
                0 -> ServiciosTab(
                    navController = navController,
                    barberName = barberName,
                    padding = padding
                )

                1 -> DireccionTab(
                    barberName = barberName,
                    padding = padding
                )
            }
        }
    }

    // 🪟 MODAL AVATAR
    if (showAvatarDialog) {
        AlertDialog(
            onDismissRequest = { showAvatarDialog = false },
            confirmButton = {
                TextButton(onClick = { showAvatarDialog = false }) {
                    Text("Cerrar")
                }
            },
            text = {
                Image(
                    painter = painterResource(id = R.drawable.leofoto),
                    contentDescription = "Avatar grande",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )
            }
        )
    }
}
