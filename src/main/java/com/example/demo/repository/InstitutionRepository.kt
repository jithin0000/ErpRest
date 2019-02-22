package com.example.demo.repository

import com.example.demo.model.Institution
import org.springframework.data.jpa.repository.JpaRepository

interface InstitutionRepository : JpaRepository<Institution, Long>
