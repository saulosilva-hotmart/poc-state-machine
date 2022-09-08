package com.example.state.machine.demo.entities

import com.example.state.machine.demo.DataStatus

data class DataUpdate(val id: Long, var nome: String, var status: DataStatus)