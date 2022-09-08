package com.example.state.machine.demo.service

import com.example.state.machine.demo.action.DataAction
import com.example.state.machine.demo.entities.DataUpdate


class DataService(private val stateMachine: StateMachine) {

    fun reactToAction(data: DataUpdate, action: DataAction) = stateMachine.processAction(action, data)
}