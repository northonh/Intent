package br.edu.ifsp.scl.ads.pdm.intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.pdm.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var outraActivityResultLauncher: ActivityResultLauncher<Intent>

    companion object {
        val PARAMETRO = "PARAMETRO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        supportActionBar?.title = "Tratando Intents"
        supportActionBar?.subtitle = "Principais tipos"

        outraActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.getStringExtra(PARAMETRO)?.let{
                    activityMainBinding.retornoTv.text = it
                }
            }
        }

        Log.v("${getString(R.string.app_name)}/${localClassName}", "onCreate: Início CC")
    }

    override fun onStart() {
        super.onStart()
        Log.v("${getString(R.string.app_name)}/${localClassName}", "onStart: Início CV")
    }

    override fun onResume() {
        super.onResume()
        Log.v("${getString(R.string.app_name)}/${localClassName}", "onResume: Início CPP")
    }

    override fun onPause() {
        super.onPause()
        Log.v("${getString(R.string.app_name)}/${localClassName}", "onPause: Fim CPP")
    }

    override fun onStop() {
        super.onStop()
        Log.v("${getString(R.string.app_name)}/${localClassName}", "onStop: Fim CV")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("${getString(R.string.app_name)}/${localClassName}", "onDestroy: Fim CC")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.outraActivityMi -> {
                // Abrir Outra Activity
                val outraActivityIntent = Intent(this, OutraActivity::class.java)
                outraActivityIntent.putExtra(PARAMETRO, activityMainBinding.parametroEt.text.toString())

                outraActivityResultLauncher.launch(outraActivityIntent)
                true
            }
            R.id.viewMi -> {
                // Abrir um navegador
                true
            }
            R.id.callMi -> {
                // Fazer uma chamada
                true
            }
            R.id.dialMi -> {
                // Abrir o discador
                true
            }
            R.id.pickMi -> {
                // Pegar uma imagem
                true
            }
            R.id.chooserMi -> {
                // Abrir listas de aplicativos
                true
            }
            else -> {
                false
            }
        }
    }
}