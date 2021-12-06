package study.anna.myfragmentapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var bottonNavigationMenu: BottomNavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottonNavigationMenu = findViewById(R.id.bottom_navigation_menu)

        bottonNavigationMenu.setOnItemSelectedListener { item ->

            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.page_1 -> {
                    fragment = FirstFragment()


                }
                R.id.page_2 -> {
                    fragment = SecondFragment()


                }

            }
replaceFragment(fragment!!)

            true
        }

        }

        fun replaceFragment(fragment: Fragment) {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_Container, fragment)
                .addToBackStack(fragment.tag)
                .commit()

        }

    }


