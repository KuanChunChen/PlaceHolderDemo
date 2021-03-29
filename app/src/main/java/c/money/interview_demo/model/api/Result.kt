package c.money.interview_demo.model.api

//class Result<T> {
//
//    var data: List<T>? = null
//
//}

sealed class Result<out R> {
    data class Success<out T>(val data: List<T>) : Result<List<T>>()
    data class Error(val exception: Exception) : Result<Nothing>()
}