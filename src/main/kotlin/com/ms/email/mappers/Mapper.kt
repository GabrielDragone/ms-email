package com.ms.email.mappers

interface Mapper<T, U> {

    fun map(t: T): U
}