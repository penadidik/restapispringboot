package com.example.demokotlin.service

import com.example.demokotlin.DemoModel

interface DemoService {

    fun saveDemo(demo: DemoModel): DemoModel

    fun findAllDemo(): List<DemoModel>

    fun deleteDemo(demoId: Int)

}