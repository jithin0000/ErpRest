package com.example.demo.controller

import com.example.demo.exceptions.InstitutionNotFoundException
import com.example.demo.model.Institution
import com.example.demo.repository.InstitutionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/institution")
class InstitutionController(@field:Autowired
                            private val institutionRepository: InstitutionRepository) {


    @GetMapping("/all")
    fun getAllInstitutionList(): Resource<MutableList<Resource<Institution>>> {

        val institutions =   institutionRepository.findAll().stream()
                .map {
                    inst -> Resource(
                        inst,
                        linkTo(methodOn(InstitutionController::class.java).getInstitutionDetailsById(inst.id)).withSelfRel(),
                        linkTo(methodOn(InstitutionController::class.java).getAllInstitutionList()).withRel("institutions")
                )
                }.collect(Collectors.toList())

        return Resource(
                institutions,
                linkTo(methodOn(InstitutionController::class.java).getAllInstitutionList()).withSelfRel()
        )


    }

    @PostMapping("/new")
    fun createNewInstitution(@RequestBody inst: Institution): Institution {

        return institutionRepository.save(inst)

    }

    @GetMapping("/inst/{id}")
    fun getInstitutionDetailsById(@PathVariable id: Long): Resource<Institution> {

        val institution = institutionRepository.findById(id).orElseThrow { InstitutionNotFoundException(id) }

        return Resource(
                institution,
                linkTo(methodOn(InstitutionController::class.java).getInstitutionDetailsById(id)).withSelfRel(),
                linkTo(methodOn(InstitutionController::class.java).getAllInstitutionList()).withRel("institutions")
        )
    }


}
