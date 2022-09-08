package com.example.state.machine.demo.state

import com.example.state.machine.demo.DataStatus
import com.example.state.machine.demo.action.ActionNotSupported
import com.example.state.machine.demo.action.DataAction
import com.example.state.machine.demo.entities.DataUpdate
import org.springframework.stereotype.Component

@Component
class PendingData: DataState(DataStatus.PENDING_DATA) {
    override fun getNextStatus(action: DataAction, data: DataUpdate): DataStatus {
        return when (action) {

            else -> {
                ActionNotSupported(data.id.toString(), this.dataStatus.toString(), action.toString())
                this.dataStatus
            }
        }
    }
}