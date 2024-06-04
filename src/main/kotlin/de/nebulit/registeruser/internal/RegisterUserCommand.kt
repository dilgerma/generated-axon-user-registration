package de.nebulit.registeruser.internal

import org.axonframework.modelling.command.TargetAggregateIdentifier
import de.nebulit.common.Command
import java.util.UUID

data class RegisterUserCommand(
    @TargetAggregateIdentifier override var aggregateId:UUID,
	var name:String,
	var vorname:String,
	var email:String
): Command
