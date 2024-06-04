package de.nebulit.registeruser.internal

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import java.util.UUID


@RestController
class RegisteruserRessource(private var commandGateway: CommandGateway) {

    var logger = KotlinLogging.logger {}

    
    @PostMapping("registeruser")
    fun processCommand(@RequestParam aggregateId:UUID,
	@RequestParam name:String,
	@RequestParam vorname:String,
	@RequestParam email:String) {
        commandGateway.send<RegisterUserCommand>(RegisterUserCommand(aggregateId,
	name,
	vorname,
	email))
    }
    

}
