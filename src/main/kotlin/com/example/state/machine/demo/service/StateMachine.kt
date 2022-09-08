package com.example.state.machine.demo.service

import com.example.state.machine.demo.DataStatus
import com.example.state.machine.demo.action.DataAction
import com.example.state.machine.demo.entities.DataUpdate
import com.example.state.machine.demo.state.DataState

class StateMachine (private val states: List<DataState>){

    fun processAction(action: DataAction, data: DataUpdate) {
        val currentState = stateFor(data.status)

        val nextStatus = currentState.nextStatus(action, data)

        data.status = nextStatus

        //Sava repository
    }

    private fun stateFor(status: DataStatus) = states.single { it.dataStatus == status }
}