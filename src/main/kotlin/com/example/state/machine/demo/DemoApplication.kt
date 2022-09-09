package com.example.state.machine.demo

import com.example.state.machine.demo.entities.DataUpdate
import com.example.state.machine.demo.service.DataService
import com.example.state.machine.demo.service.StateMachine
import com.example.state.machine.demo.state.*
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication(): CommandLineRunner {

	override fun run(vararg args: String?) {

		val list = mutableListOf(
			Pending(),
			ValidateBureau(),
			ValidateRegulation(),
			Reprocess(),
			PendingData()
		)

		val stateMachine = StateMachine(list)
		val dataService = DataService(stateMachine)

		val data = DataUpdate(1, "Saulo Braga", DataStatus.PENDING)

		dataService.reactToAction(data, com.example.state.machine.demo.action.VerifyBureau())
		dataService.reactToAction(data, com.example.state.machine.demo.action.Reprocess())
		dataService.reactToAction(data, com.example.state.machine.demo.action.VerifyRegularization())
		dataService.reactToAction(data, com.example.state.machine.demo.action.Regularization())
		dataService.reactToAction(data, com.example.state.machine.demo.action.PendingData())

	}

}



fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
