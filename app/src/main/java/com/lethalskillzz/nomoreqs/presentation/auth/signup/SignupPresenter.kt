package com.lethalskillzz.nomoreqs.presentation.auth.signup

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.lethalskillzz.nomoreqs.data.AppRepository
import com.lethalskillzz.nomoreqs.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 16/11/2017.
 */


class SignupPresenter<V : SignupMvpView> @Inject
constructor(appRepository: AppRepository,
            compositeDisposable: CompositeDisposable) : BasePresenter<V>(appRepository, compositeDisposable),SignupMvpPresenter<V> {


    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

    }


    override fun signupUser(email: String, password: String) {

        val auth = FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->
            if (task.isSuccessful) {
                //Registration OK
                val firebaseUser = auth.currentUser!!
            } else {
                //Registration error
            }
        }
    }

    companion object {
        private val TAG = "SignupPresenter"
    }


}
