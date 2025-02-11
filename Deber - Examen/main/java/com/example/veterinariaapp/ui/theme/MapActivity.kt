import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState


class MapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val latitud = intent.getDoubleExtra("LATITUD", 0.0)
        val longitud = intent.getDoubleExtra("LONGITUD", 0.0)

        setContent {
            MapScreen(latitud = latitud, longitud = longitud)
        }
    }
}

@Composable
fun MapScreen(latitud: Double, longitud: Double) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            LatLng(latitud, longitud), 15f
        )
    }

    GoogleMap(cameraPositionState = cameraPositionState) {
        Marker(
            title = "Veterinario",
            snippet = "Ubicación guardada"
        )
    }
}
