package br.edu.ifsp.scl.ads.pdm.intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.pdm.intent.databinding.ActivityOutraBinding

class OutraActivity : AppCompatActivity() {
    private val activityOutraBinding: ActivityOutraBinding by lazy {
        ActivityOutraBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityOutraBinding.root)

        supportActionBar?.title = "Outra Activity"
        supportActionBar?.subtitle = "Recebe e retorna um valor"

        intent.getStringExtra(MainActivity.PARAMETRO)?.run {
            activityOutraBinding.recebidoTv.text = this
        }

        activityOutraBinding.retornarBt.setOnClickListener{
            val retornoIntent = Intent()
            retornoIntent.putExtra(MainActivity.PARAMETRO, activityOutraBinding.retornoEt.text.toString())
            setResult(RESULT_OK, retornoIntent)

            finish()
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
}