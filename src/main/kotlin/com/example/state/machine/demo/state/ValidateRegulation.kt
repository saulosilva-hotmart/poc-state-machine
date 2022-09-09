package com.example.state.machine.demo.state

import com.example.state.machine.demo.DataStatus
import com.example.state.machine.demo.action.*
import com.example.state.machine.demo.entities.DataUpdate
import org.springframework.stereotype.Component

@Component
class ValidateRegulation: DataState(DataStatus.VERIFY_REGULARIZATION) {
    override fun getNextStatus(action: DataAction, data: DataUpdate): DataStatus {
        return when (action) {
            is com.example.state.machine.demo.action.Regularization -> {
                //Comando ou estratégia para executar
                DataStatus.REGULARIZATION
            }

            is com.example.state.machine.demo.action.PendingData -> {
                //Comando ou estratégia para executar
                DataStatus.PENDING_DATA
            }

            else -> {
                ActionNotSupported(data.id.toString(), this.dataStatus.toString(), action.toString())
                this.dataStatus
            }
        }
    }
}