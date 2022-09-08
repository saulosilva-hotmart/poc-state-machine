package com.example.state.machine.demo.state

import com.example.state.machine.demo.DataStatus
import com.example.state.machine.demo.action.DataAction
import com.example.state.machine.demo.entities.DataUpdate
import org.apache.logging.log4j.LogManager.getLogger

abstract class DataState (val dataStatus: DataStatus){

    fun nextStatus(action: DataAction, data: DataUpdate): DataStatus {
        val currentStatus = this.dataStatus

        val nextStatus = getNextStatus(action, data)

        if (nextStatus != currentStatus) {
            logger.info("Id: ${data.id}. Status alterado de $currentStatus para $nextStatus.")
        } else {
            logger.info("Id: ${data.id}. Status não foi alterado. Status: $currentStatus")
        }

        return nextStatus
    }

    protected abstract fun getNextStatus(action: DataAction, data: DataUpdate): DataStatus

    companion object {
        private val logger = getLogger()
    }
}