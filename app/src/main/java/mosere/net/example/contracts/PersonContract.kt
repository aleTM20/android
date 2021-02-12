package mosere.net.example.contracts

import mosere.net.example.models.Person

interface PersonContract {
    interface View {
        fun onLoadedPerson(persons: List<Person>)
        fun onItemClickListener(persons: Person)
    }

    interface Presenter {
        fun onLoadPerson(numberOfPerson: Int)
        fun onLoadedPerson(persons: List<Person>)
    }

    interface Model {
        fun onLoadPerson(numberOfPerson: Int)
    }
}