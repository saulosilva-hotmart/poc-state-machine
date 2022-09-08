package com.example.state.machine.demo.state

import com.example.state.machine.demo.DataStatus
import com.example.state.machine.demo.action.ActionNotSupported
import com.example.state.machine.demo.action.DataAction
import com.example.state.machine.demo.action.VerifyBureau
import com.example.state.machine.demo.entities.DataUpdate
import org.springframework.stereotype.Component

@Component
class Pending : DataState(DataStatus.PENDING) {
    override fun getNextStatus(action: DataAction, data: DataUpdate): DataStatus {
        return when (action) {
            is VerifyBureau -> {
                //Comando ou estratégia para executar
                DataStatus.VERIFY_BUREAU
            }

            else -> {
                ActionNotSupported(data.id.toString(), this.dataStatus.toString(), action.toString())
                this.dataStatus
            }
        }
    }
}