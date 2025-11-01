package lat.pam.sweetmuse

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import lat.pam.sweetmuse.databinding.ActivityAddressBinding // Pastikan import ini benar

class AddressActivity : AppCompatActivity() {

    // Gunakan lateinit var untuk menyimpan instance binding
    private lateinit var binding: ActivityAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi View Binding
        binding = ActivityAddressBinding.inflate(layoutInflater)

        // 2. Set ContentView menggunakan root dari binding
        setContentView(binding.root)

        // Tidak perlu lagi findViewById atau deklarasi EditText di luar onCreate,
        // karena semuanya dapat diakses langsung melalui objek 'binding'.

        binding.pesanSekarang.setOnClickListener {

            // Akses komponen melalui objek binding
            val nama = binding.etNamaLengkap.text.toString().trim()
            val alamat = binding.alamatLengkap.text.toString().trim()
            val patokan = binding.patokanAlamat.text.toString().trim()
            val catatan = binding.catatan.text.toString().trim()
            val pembayaran = binding.pembayaran.text.toString().trim()

            // Perbaikan Logika Validasi:
            // Cek semua field wajib. Saya hapus validasi 'catatan' karena biasanya opsional.
            if (nama.isEmpty() || alamat.isEmpty() || patokan.isEmpty() || pembayaran.isEmpty()) {
                Toast.makeText(this, "Mohon lengkapi Nama, Alamat, Patokan, dan Pembayaran.", Toast.LENGTH_LONG).show()
            } else {
                // Proses data & Lanjut ke halaman konfirmasi
                Toast.makeText(
                    this,
                    "Pesanan berhasil diterima! Menuju halaman Konfirmasi.",
                    Toast.LENGTH_SHORT
                ).show()

                // Pindah ke halaman konfirmasi (Ganti ConfirmationActivity::class.java dengan Activity yang sesuai)
                // Contoh:
                val intent = Intent(this, ConfirmationActivity::class.java)
                startActivity(intent)
            }
        }
    }
}