package tun.kt.data.datasource

interface FirebaseAuthDataSource {
    fun checkCurrentUser()
    fun saveAccessToken()
    fun checkTokenExpires()
}