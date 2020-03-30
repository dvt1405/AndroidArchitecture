package tun.kt.data

interface Mapper<I, O> {
    fun mapFrom(input: I): O
    fun mapTo(input: O): I
}