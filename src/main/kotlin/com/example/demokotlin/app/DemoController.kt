package com.example.demokotlin.app

import com.example.demokotlin.base.BaseController
import com.example.demokotlin.service.DemoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class DemoController: BaseController() {

    @Autowired
    private lateinit var demoService: DemoService

    @GetMapping("/")
    fun getIndex(): String{
        return "index"
    }

    @PostMapping("/demo")
    @ResponseBody
    fun insertupdate(@RequestBody demo: String): DemoModel {
        val dataDemo = convertResponseToModel(demo, "data", DemoModel::class.java)
        return demoService.saveDemo(dataDemo)
    }

    @PostMapping("/demo/del")
    @ResponseBody
    fun delete(@RequestBody id: String) {
        val data = convertResponseToJson(id, "id")
        return demoService.deleteDemo(data.toString().toInt())
    }

}