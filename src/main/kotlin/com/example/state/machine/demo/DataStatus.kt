package com.example.state.machine.demo

enum class DataStatus {
    PENDING,
    VERIFY_BUREAU,
    REPROCESS,
    VERIFY_REGULARIZATION,
    REGULARIZATION,
    PENDING_DATA
}