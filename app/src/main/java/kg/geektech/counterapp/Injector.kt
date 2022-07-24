package kg.geektech.counterapp

import kg.geektech.counterapp.model.CounterModel
import kg.geektech.counterapp.presenter.Presenter

class Injector {

    companion object{
        fun getPresenter(): Presenter{
            return Presenter()
        }
        fun getModel(): CounterModel{
            return CounterModel()
        }
    }
}