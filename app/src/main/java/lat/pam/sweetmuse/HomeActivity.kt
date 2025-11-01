package lat.pam.sweetmuse

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private val daftarMakanan = listOf(
        "Cheesecake Original (New York Style)",
        "Strawberry Cheesecake",
        "Blueberry Cheesecake",
        "Chocolate Cheesecake",
        "Matcha Cheesecake",
        "Red Velvet Cheesecake",
        "Oreo Cheesecake",
        "Lemon Cheesecake",
        "Basque Burnt Cheesecake",
        "Biscoff Cheesecake"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Akses Container LinearLayout tempat daftar makanan akan dimasukkan
        val listContainer = findViewById<LinearLayout>(R.id.list_makanan)

        // Buat TextView tiap item makanan secara dinamis
        for ((index, makanan) in daftarMakanan.withIndex()) {
            val textView = TextView(this).apply {
                // Tambahkan nomor urut seperti di list sebelumnya
                text = "${index + 1}. $makanan"
                textSize = 16f
                setPadding(24, 24, 24, 24) // Padding lebih besar untuk estetika

                // Pastikan R.drawable.bg_card sudah dibuat. Ini bisa berupa shape XML.
                setBackgroundResource(R.drawable.bg_card)

                // Gunakan resources.getColor/getColorStateList untuk kompatibilitas
                setTextColor(resources.getColor(R.color.black, theme))

                // Tambahkan efek klik pada item
                isClickable = true
                isFocusable = true

                // Logika saat item makanan diklik
                setOnClickListener {
                    // Mengarahkan ke OrderOptionActivity (Screen 6)
                    val intent = Intent(this@HomeActivity, OrderOptionActivity::class.java)
                    // Mengirim nama makanan yang dipilih (misalnya untuk ditampilkan di keranjang)
                    intent.putExtra("nama_makanan", makanan)
                    startActivity(intent)
                    Toast.makeText(this@HomeActivity, "$makanan ditambahkan ke keranjang!", Toast.LENGTH_SHORT).show()
                }
            }

            // Atur margin bawah untuk memisahkan item
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 0, 12) // Margin bawah 12dp
            }

            listContainer.addView(textView, params)
        }

        // Navigasi bawah

        // nav_home: Sudah aktif di layout, tidak perlu listener pindah
        // findViewById<LinearLayout>(R.id.nav_home).setOnClickListener { /* Do nothing */ }

        // nav_order: Pindah ke OrderOptionActivity (Screen 6)
        findViewById<LinearLayout>(R.id.nav_order).setOnClickListener {
            // Kita bisa menggunakan OrderOptionActivity untuk keranjang
            startActivity(Intent(this, OrderOptionActivity::class.java))
        }

        // nav_profile: Pindah ke ProfileActivity
        findViewById<LinearLayout>(R.id.nav_profile).setOnClickListener {
            // Pastikan ProfileActivity sudah dibuat
            // val profileIntent = Intent(this, ProfileActivity::class.java)
            // startActivity(profileIntent)
            Toast.makeText(this, "Menuju halaman Profil...", Toast.LENGTH_SHORT).show()
        }
    }
}