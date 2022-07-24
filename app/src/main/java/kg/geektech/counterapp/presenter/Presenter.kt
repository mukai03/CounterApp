package kg.geektech.counterapp.presenter

import kg.geektech.counterapp.Injector
import kg.geektech.counterapp.view.CounterView

class Presenter {

    lateinit var view: CounterView
    private val model = Injector.getModel()

    fun increment(){
        model.increment()
        view.updateCount(model.getCount().toString())
        if (model.getCount()==10){
            view.showToastPlus()

            if (model.getCount()==15){
                view.showGreenPlus()
            }
        }
    }

    fun decrement(){
        model.decrement()
        view.updateCount(model.getCount().toString())
    }

    fun attachView(view: CounterView) {
        this.view=view
    }


}