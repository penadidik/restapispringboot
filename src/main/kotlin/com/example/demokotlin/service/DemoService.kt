package com.example.demokotlin.service

import com.example.demokotlin.DemoModel

interface DemoService {

    fun saveDemo(demo: DemoModel): DemoModel

    fun findAllDemo(): List<DemoModel>

    fun findDemoById(demoId: Int): DemoModel

    fun deleteDemo(demoId: Int)

}