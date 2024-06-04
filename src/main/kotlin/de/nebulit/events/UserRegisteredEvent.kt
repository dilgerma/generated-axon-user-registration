package de.nebulit.events

import de.nebulit.common.Event

import java.util.UUID

data class UserRegisteredEvent(
    var aggregateId:UUID,
	var email:String,
	var name:String,
	var vorname:String
) : Event
