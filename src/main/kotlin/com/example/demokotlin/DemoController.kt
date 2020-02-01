package com.example.demokotlin

import com.example.demokotlin.service.DemoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class DemoController {

    @Autowired
    private lateinit var demoService: DemoService

    @GetMapping("/")
    fun getIndex(): String{
        return "index"
    }

    @PostMapping("/demo")
    fun insertupdate(@RequestBody demo: DemoModel){
        demoService.saveDemo(demo)
    }

    @GetMapping("/demo/viewby/{id}")
    fun viewbyid(@PathVariable(value = "id") id: Int): DemoModel{
        return demoService.findDemoById(id)
    }

    @DeleteMapping
    fun delete(@PathVariable(value = "id") id: Int){
        return demoService.deleteDemo(id)
    }

}