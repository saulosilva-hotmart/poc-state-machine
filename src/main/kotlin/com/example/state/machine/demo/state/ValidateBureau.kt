package com.example.state.machine.demo.state

import com.example.state.machine.demo.DataStatus
import com.example.state.machine.demo.action.*
import com.example.state.machine.demo.entities.DataUpdate
import org.springframework.stereotype.Component

@Component
class ValidateBureau : DataState(DataStatus.VERIFY_BUREAU) {
    override fun getNextStatus(action: DataAction, data: DataUpdate): DataStatus {
        return when (action) {
            is com.example.state.machine.demo.action.Reprocess -> {
                //Comando ou estratégia para executar
                DataStatus.REPROCESS
            }

            is VerifyRegularization -> {
                //Comando ou estratégia para executar
                DataStatus.VERIFY_REGULARIZATION
            }

            else -> {
                ActionNotSupported(data.id.toString(), this.dataStatus.toString(), action.toString())
                this.dataStatus
            }
        }
    }
}