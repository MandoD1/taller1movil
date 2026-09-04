    package com.example.taller1movil

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import com.example.taller1movil.navigation.NavegacionApp
    import com.example.taller1movil.ui.theme.TemaApp

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                TemaApp {
                    NavegacionApp()
                }
            }
        }
    }