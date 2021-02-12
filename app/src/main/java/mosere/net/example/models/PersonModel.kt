package mosere.net.example.models

import mosere.net.example.contracts.PersonContract

class PersonModel(private val personPresenter: PersonContract.Presenter) : PersonContract.Model {
    override fun onLoadPerson(numberOfPerson: Int) {
        val personList: MutableList<Person> = ArrayList<Person>()
        for (index in 1..numberOfPerson)
            personList.add(
                Person(
                    id = index,
                    firstName = "Alejandro $index",
                    lastName = "Teresa $index",
                    email = "Mosere@mosere.net",
                    phone = "+52 (712) 1789878"
                )
            )

        personPresenter.onLoadedPerson(personList)
    }
}