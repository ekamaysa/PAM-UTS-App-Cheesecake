package lat.pam.sweetmuse

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import lat.pam.sweetmuse.databinding.ActivityOrderOptionBinding

class OrderOptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderOptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrderOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Logika Tombol Kirim Pesanan (Order ke Alamat)
        binding.btnKirim.setOnClickListener {
            // Pindah ke Screen 7: AddressActivity (untuk mengisi detail pengiriman)
            val intent = Intent(this, AddressActivity::class.java)
            // Anda mungkin ingin mengirim data keranjang di sini (Opsional)
            startActivity(intent)
        }

        // 2. Logika Navigasi Bawah Kustom
        setupBottomNavigation()

        // Asumsi: Aplikasi ini adalah versi sederhana, sehingga hanya menampilkan daftar statis
        // Jika ini adalah aplikasi nyata, Anda akan mengisi list_order secara dinamis
    }

    private fun setupBottomNavigation() {
        // Navigasi ke Home (Screen 5)
        binding.navHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            // Agar Home selalu menjadi root saat diklik dari nav bar
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish() // Tutup activity ini
        }

        // Navigasi ke Order/Keranjang (Activity ini sendiri)
        binding.navOrder.setOnClickListener {
            // Sudah berada di OrderOptionActivity, tidak melakukan apa-apa atau refresh
            Toast.makeText(this, "Sudah di halaman Keranjang/Order", Toast.LENGTH_SHORT).show()
        }

        // Navigasi ke Profile (Perlu ProfileActivity baru)
        binding.navProfile.setOnClickListener {
            // Gantilah ProfileActivity::class.java dengan nama Activity Profil Anda
            // val intent = Intent(this, ProfileActivity::class.java)
            // startActivity(intent)
            Toast.makeText(this, "Menuju halaman Profil", Toast.LENGTH_SHORT).show()
        }
    }
}