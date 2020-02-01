package com.example.demokotlin.service

import com.example.demokotlin.app.DemoModel
import com.example.demokotlin.app.DemoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
open class DemoServiceImpl: DemoService {

    @Autowired
    private lateinit var demoRepo: DemoRepository

    override fun saveDemo(demo: DemoModel): DemoModel {
        return demoRepo.save(demo)
    }

    override fun findAllDemo(): List<DemoModel> {
        return demoRepo.findAll()
    }

    override fun deleteDemo(demoId: Int) {
        demoRepo.deleteById(demoId)
    }

}