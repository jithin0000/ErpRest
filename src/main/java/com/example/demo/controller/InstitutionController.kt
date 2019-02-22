package com.example.demo.controller

import com.example.demo.exceptions.InstitutionNotFoundException
import com.example.demo.model.Institution
import com.example.demo.repository.InstitutionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/institution")
class InstitutionController(@field:Autowired
                            private val institutionRepository: InstitutionRepository) {


    @GetMapping("/all")
    fun getAllInstitutionList(): List<Institution>{

        return institutionRepository.findAll()

    }

    @PostMapping("/new")
    fun createNewInstitution(@RequestBody inst: Institution): Institution {

        return institutionRepository.save(inst)

    }

    @GetMapping("/{id}")
    fun getInstitutionDetailsById(@PathVariable id: Long): Institution {

        return institutionRepository.findById(id).orElseThrow { InstitutionNotFoundException(id) }


    }


}
