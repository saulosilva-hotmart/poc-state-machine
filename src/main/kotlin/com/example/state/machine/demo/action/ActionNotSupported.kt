package com.example.state.machine.demo.action

import org.apache.logging.log4j.LogManager.getLogger

class ActionNotSupported(id:String, status: String, action: String) {
    init {
        logger.warn("Id: $id Status $status cannot be left with action $action.")
    }

    companion object {
        private val logger = getLogger()
    }
}