package com.example.demo.exceptions

import java.lang.RuntimeException

class InstitutionNotFoundException(id: Long) : RuntimeException("No Institution With this id $id ") {


}
