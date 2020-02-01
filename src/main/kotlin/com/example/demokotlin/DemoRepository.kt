package com.example.demokotlin

import org.springframework.data.jpa.repository.JpaRepository

interface DemoRepository : JpaRepository<DemoModel, Int>