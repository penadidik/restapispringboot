package com.example.demokotlin.service

import com.example.demokotlin.DemoModel
import com.example.demokotlin.DemoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
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

    override fun findDemoById(demoId: Int): DemoModel {
        return demoRepo.findByIdOrNull(demoId)!!
    }

    override fun deleteDemo(demoId: Int) {
        demoRepo.deleteById(demoId)
    }

}