import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VeterinariosScreen(
                veterinarios = listOf(
                    Veterinario(1, "Dr. Juan Pérez", -0.180653, -78.467834),
                    Veterinario(2, "Dra. Ana López", -2.19616, -79.88621),
                    Veterinario(3, "Dr. Carlos Ruiz", -3.99841, -79.20178)
                )
            )
        }
    }
}

@Composable
fun VeterinariosScreen(veterinarios: List<Veterinario>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Lista de Veterinarios")
        veterinarios.forEach { veterinario ->
            Button(
                onClick = {
                    val context = androidx.compose.ui.platform.LocalContext.current
                    val intent = Intent(context, MapActivity::class.java).apply {
                        putExtra("LATITUD", veterinario.latitud)
                        putExtra("LONGITUD", veterinario.longitud)
                    }
                    context.startActivity(intent)
                },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(text = "Ver mapa de ${veterinario.nombre}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewVeterinariosScreen() {
    VeterinariosScreen(
        veterinarios = listOf(
            Veterinario(1, "Dr. Juan Pérez", -0.180653, -78.467834),
            Veterinario(2, "Dra. Ana López", -2.19616, -79.88621),
            Veterinario(3, "Dr. Carlos Ruiz", -3.99841, -79.20178)
        )
    )
}
