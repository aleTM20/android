package mosere.net.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import mosere.net.example.R
import mosere.net.example.contracts.PersonContract
import mosere.net.example.databinding.PersonCardBinding
import mosere.net.example.models.Person

class PersonAdapter(private val personList: MutableList<Person>, private val onItemClickListener: PersonContract.View) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.person_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            onItemClickListener.onItemClickListener(personList[position])
        }
        holder.render(personList[position])
    }

    override fun getItemCount(): Int = personList.size


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val binding = PersonCardBinding.bind(view)

        fun render(person: Person) {
            binding.firsName.text = person.firstName
            binding.lastName.text = person.lastName
            binding.email.text = person.email
            binding.phone.text = person.phone
        }
    }
}