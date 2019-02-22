package com.example.demo.advice

import com.example.demo.exceptions.InstitutionNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class InstitutionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(InstitutionNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun institutionNotFoundHandler(ex: InstitutionNotFoundException):String{
        return ex.message!!

    }

}