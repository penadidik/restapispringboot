package com.example.demokotlin

import javax.persistence.*

@Entity
@Table(name = "tb_data")
class DemoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null
    @Column(name = "nama_lengkap")
    var fullName = ""
    @Column(name = "alamat")
    var alamat = ""
}