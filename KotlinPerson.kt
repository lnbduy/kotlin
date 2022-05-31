package com.duyle.kotlin

import java.util.*

data class KotlinPerson(val id: Long, val title: String, val firstName: String, val surname: String, val dateOfBirth: Calendar?) {
    override fun toString() =  "$title $firstName $surname"

    companion object {
        fun getAge(dateOfBirth: Calendar?): Int {
            if (dateOfBirth == null) {
                return -1
            }
            val today: Calendar =  GregorianCalendar();
            val years: Int = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
            if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) {
                return years -1;
            } else {
                return years;
            }
        }
    }

    fun getAge(): Int {
        return Companion.getAge(dateOfBirth)
    }
}

fun main(args: Array<String>) {
    val john: KotlinPerson = KotlinPerson(1L, "Mr", "John", "Blue", GregorianCalendar(1977, 9,3))
    val jane = KotlinPerson(2L, "Mrs", "Jane", "Green", null);
    println("${john}'s age is ${john.getAge()}")
    println("${jane}'s age is ${jane.getAge()}")
    println("The age of someone born on 3rd May 1988 is ${KotlinPerson.getAge(GregorianCalendar(1985,5,3))}")
}