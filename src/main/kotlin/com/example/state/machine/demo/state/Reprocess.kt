package com.example.state.machine.demo.state

import com.example.state.machine.demo.DataStatus
import com.example.state.machine.demo.action.ActionNotSupported
import com.example.state.machine.demo.action.DataAction
import com.example.state.machine.demo.action.VerifyRegularization
import com.example.state.machine.demo.entities.DataUpdate
import org.springframework.stereotype.Component

@Component
class Reprocess : DataState(DataStatus.REPROCESS) {
    override fun getNextStatus(action: DataAction, data: DataUpdate): DataStatus {
        return when (action) {
            is com.example.state.machine.demo.action.VerifyBureau -> {
                //Comando ou estratégia para executar
                DataStatus.VERIFY_BUREAU
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