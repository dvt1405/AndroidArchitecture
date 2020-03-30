package tun.kt.service.model

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import tun.kt.data.Mapper

data class User constructor(
    var email: String?,
    var password: String?,
    var userUid: String?,
    var avatar: String?,
    var isAnonymous: Boolean?,
    var displayName: String?,
    var photoUrl: String?,
    var getProviderId: String?,
    var phoneNumber: String?
) {
    constructor(email: String, password: String, displayName: String?) : this(
        email,
        password,
        null,
        null,
        null,
        displayName,
        null,
        null,
        null
    )
}

class MapperUser(private val firebaseAuth: FirebaseAuth) : Mapper<FirebaseUser?, User> {
    override fun mapFrom(input: FirebaseUser?): User {
        return User(
            input?.email?: error("Email"),
            "pass",
            input.displayName
        )
    }

    override fun mapTo(input: User): FirebaseUser? = firebaseAuth.currentUser

}