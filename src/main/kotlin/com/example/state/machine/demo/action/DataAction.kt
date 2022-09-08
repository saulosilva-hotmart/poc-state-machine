package com.example.state.machine.demo.action

interface DataAction

class Pending : DataAction
class VerifyBureau : DataAction
class Reprocess : DataAction
class VerifyRegularization : DataAction
class Regularization : DataAction
class PendingData : DataAction

