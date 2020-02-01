package com.example.demokotlin.app

import com.example.demokotlin.app.DemoModel
import org.springframework.data.jpa.repository.JpaRepository

interface DemoRepository : JpaRepository<DemoModel, Int>