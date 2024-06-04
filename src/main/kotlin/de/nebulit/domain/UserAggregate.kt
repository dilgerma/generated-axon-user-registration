package de.nebulit.domain

import de.nebulit.events.UserRegisteredEvent
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import java.util.UUID


@Aggregate
class UserAggregate {
    fun registerUser(name: String, vorname: String, email: String): UserAggregate? {
        AggregateLifecycle.apply(
            UserRegisteredEvent(
                this@UserAggregate.aggregateId,
                email,
                name,
                vorname
            )
        )
        return this
    }

    @AggregateIdentifier
    lateinit var aggregateId: UUID


}
