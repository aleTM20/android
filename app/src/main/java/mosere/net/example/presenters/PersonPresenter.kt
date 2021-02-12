package mosere.net.example.presenters

import mosere.net.example.contracts.PersonContract
import mosere.net.example.models.Person
import mosere.net.example.models.PersonModel

class PersonPresenter(private val personView: PersonContract.View) : PersonContract.Presenter {

    private val personModel: PersonModel = PersonModel(this)
    override fun onLoadPerson(numberOfPerson: Int) {
        personModel.onLoadPerson(numberOfPerson)
    }

    override fun onLoadedPerson(persons: List<Person>) {
        personView.onLoadedPerson(persons)
    }
}