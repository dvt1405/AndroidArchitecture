package tun.kt.displaymap

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import org.w3c.dom.Text
import tun.kt.data.DataState
import tun.kt.displaymap.di.DaggerMapComponent
import tun.kt.service.Log.error
import tun.kt.subfeature.BaseFragment
import tun.kt.usecase.di.UseCaseComponent
import tun.kt.usecase.usecase.GetImage
import java.lang.Exception
import java.lang.NullPointerException
import java.util.*
import javax.inject.Inject

class FragmentDisplayMap() : SupportMapFragment(), OnMapReadyCallback,
    GoogleMap.OnMyLocationClickListener,
    GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener,
    GoogleMap.OnInfoWindowLongClickListener, GoogleMap.OnInfoWindowClickListener {
    lateinit var btnZoomIn: TextView
    lateinit var btnZoomOut: TextView
    lateinit var map: SupportMapFragment
    lateinit var googleMap: GoogleMap
    lateinit var geocoder: Geocoder

    @Inject
    lateinit var getImage: GetImage

    override fun onCreate(p0: Bundle?) {
        super.onCreate(p0)
        usecaseComponent?.let {
            DaggerMapComponent.builder()
                .useCaseComponent(it)
                .build()
                .inject(this)
        }
    }

    override fun onResume() {
        super.onResume()
        getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        try {
            googleMap = p0!!
            geocoder = Geocoder(activity!!, Locale.getDefault())
//            googleMap.setInfoWindowAdapter(
//                CustomInfoWindowAdapter(layoutInflater.inflate(R.layout.custom_info_window,null)))
//            showAllMarkerSaved(this)
            googleMap.setOnMyLocationClickListener(this)
            googleMap.setOnMapClickListener(this)
            googleMap.setOnInfoWindowLongClickListener(this)
            googleMap.setOnInfoWindowClickListener(this)
            googleMap.setOnMarkerClickListener(this)
            googleMap.setOnInfoWindowLongClickListener(GoogleMap.OnInfoWindowLongClickListener {
//                showDialogMarker(it)
            })
        } catch (e: Exception) {

        }
    }

    override fun onMyLocationClick(p0: Location) {
        googleMap.addMarker(
            MarkerOptions().position(
                LatLng(
                    p0.latitude,
                    p0.longitude
                )
            ).title("My location")
        )
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        if (p0 != null) {
            Log.i("Window shown?", p0.isInfoWindowShown.toString())
            val address: List<Address> =
                geocoder.getFromLocation(p0.position.latitude, p0.position.longitude, 1)
            try {
                p0.title = address.get(0).getAddressLine(0)
            } catch (ex: IndexOutOfBoundsException) {
                p0.title = "No info for this location"
            }
            if (p0.isInfoWindowShown) {
                p0.hideInfoWindow()
            } else {
                p0.showInfoWindow()
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(p0.position))
            }

        }

        return true
    }

    override fun onMapClick(p0: LatLng?) {
        addMarker(p0)
    }

    override fun onInfoWindowLongClick(p0: Marker?) {

    }

    override fun onInfoWindowClick(p0: Marker?) {

    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                activity!!, Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            googleMap.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                activity!!,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                1
            )
        }
    }

    fun addMarker(latLng: LatLng?) {
        try {
            val marker = MarkerOptions().position(latLng!!)
            googleMap.addMarker(marker)
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
            getImage(
                tun.kt.data.model.Marker(
                    null,
                    21.36724381361513.toString(),
                    105.28680101037024.toString(),
                    null,
                    null,
                    null
                )
            ).observe(this, androidx.lifecycle.Observer {
                when(it) {
                    is DataState.Success -> {
                        Log.e("Success",it.value.size!!.toString())
                    }
                    is DataState.Failure -> {
                        Log.e("Failt",it.throwable.message,it.throwable)
                    }
                }
            })
        } catch (e: Exception) {

        }

    }

    companion object {
        var usecaseComponent: UseCaseComponent? = null
    }
}