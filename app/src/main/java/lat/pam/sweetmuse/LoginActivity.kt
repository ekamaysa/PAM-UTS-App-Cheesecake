package lat.pam.sweetmuse


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import lat.pam.sweetmuse.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginSubmit.setOnClickListener {
            val username = binding.etUsernameLogin.text.toString()
            val password = binding.etPasswordLogin.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Simulasi Login Sukses
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                // Pindah ke Screen 5: HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                // Hapus semua Activity sebelumnya agar pengguna tidak bisa kembali ke halaman login
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                Toast.makeText(this, "Mohon isi semua kolom.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}