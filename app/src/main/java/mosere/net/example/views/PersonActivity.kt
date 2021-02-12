package mosere.net.example.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import mosere.net.example.adapter.PersonAdapter
import mosere.net.example.contracts.PersonContract
import mosere.net.example.databinding.ActivityPersonBinding
import mosere.net.example.models.Person
import mosere.net.example.presenters.PersonPresenter

class PersonActivity : AppCompatActivity(), PersonContract.View {
    private lateinit var personPresenter: PersonPresenter
    private lateinit var binding: ActivityPersonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        personPresenter = PersonPresenter(this)
        personPresenter.onLoadPerson(10)
    }

    override fun onLoadedPerson(persons: List<Person>) {
        binding.recyclerPerson.layoutManager = LinearLayoutManager(this)
        binding.recyclerPerson.adapter = PersonAdapter(persons as MutableList<Person>, this)
    }

    override fun onItemClickListener(persons: Person) {
        Toast.makeText(
            this,
            "My name is ${persons.firstName} ${persons.lastName}",
            Toast.LENGTH_LONG
        ).show()
    }
}