package com.example.common.mapper

interface DeezerMapper<I,O>{
    fun map(input:I?):O
}