package com.daniel.raduca.countryflags.util

import java.text.NumberFormat

fun numberFormatter(number: Number): String = NumberFormat.getIntegerInstance().format(number)

fun concatStrings(strings: List<String>?): String? {
    return strings?.let {
        when (it.size) {
            0 -> ""
            1 -> it[0]
            else -> {
                it.joinToString(", ") { it -> it }
            }
        }
    }
}