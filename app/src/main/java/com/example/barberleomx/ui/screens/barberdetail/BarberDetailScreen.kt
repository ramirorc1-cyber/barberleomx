package com.example.barberleomx.ui.screens.barberdetail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(
    barberName: String,
    navController: NavController
) {
    val context = LocalContext.current
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(barberName) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            // ---------- PORTADA ----------
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.barber),
                    contentDescription = "Portada",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Avatar
                Image(
                    painter = painterResource(R.drawable.leofoto),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(110.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 55.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(64.dp))

            // ---------- NOMBRE ----------
            Text(
                text = barberName,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ---------- REDES Y TEL ----------
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Button(onClick = {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com")
                        )
                    )
                }) {
                    Text("Instagram")
                }

                Spacer(modifier = Modifier.width(12.dp))

                Button(onClick = {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com")
                        )
                    )
                }) {
                    Text("Facebook")
                }

                Spacer(modifier = Modifier.width(12.dp))

                IconButton(onClick = {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:5512345678")
                    context.startActivity(intent)
                }) {
                    Icon(Icons.Default.Call, contentDescription = "Llamar")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ---------- TABS ----------
            TabRow(selectedTabIndex = selectedTab) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = { Text("Servicios") }
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = { Text("Ubicación") }
                )
            }

            // ---------- CONTENIDO ----------
            when (selectedTab) {
                0 -> ServiciosTab(
                    navController = navController,
                    barberName = barberName,
                    padding = 16.dp
                )

                1 -> DireccionTab(
                    barberName = barberName,
                    context = context,
                    padding = PaddingValues(16.dp)
                )
            }
        }
    }
}
