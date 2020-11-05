package nl.svdoetelaar.madlevel5task2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_games.*
import nl.svdoetelaar.madlevel5task2.R

class GamesActivity : AppCompatActivity() {

    var selectedMenu = R.menu.delete_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)
        setSupportActionBar(findViewById(R.id.toolbar))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(selectedMenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.delete -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun setToolbarWithBackButton() {

    }

    fun setToolbarWithoutBackButton() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.setHomeButtonEnabled(false)
    }

    fun setSupportActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}