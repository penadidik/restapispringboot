package com.example.demokotlin

import com.example.demokotlin.service.DemoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApIController {

    @Autowired
    private lateinit var demoService: DemoService

    @GetMapping("/demo/alldata")
    fun getAllData(): List<DemoModel> = demoService.findAllDemo()

}