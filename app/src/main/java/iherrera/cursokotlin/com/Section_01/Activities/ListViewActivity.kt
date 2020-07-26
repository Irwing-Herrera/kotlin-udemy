package iherrera.cursokotlin.com.Section_01.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Adapters.PersonAdapter
import iherrera.cursokotlin.com.Section_01.Models.Person
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        personList = getPersons()
        adapter = PersonAdapter(this,R.layout.list_view_person, personList)

        listViewPerson.adapter = adapter

    }

    private fun getPersons(): List<Person> {
       return listOf(
            Person("Irwing", "Herrera", 27),
            Person("Allison", "Herrera", 27),
            Person("Alexis", "Tamariz", 27),
            Person("Jonathan", "Pereira", 27),
            Person("Carlos", "Lopez", 27)
        )
    }
}