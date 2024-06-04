package de.nebulit.registereduser

import de.nebulit.common.ReadModel
import de.nebulit.common.Query
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.modelling.command.AggregateIdentifier
import org.springframework.stereotype.Component
import java.util.UUID
import de.nebulit.events.UserRegisteredEvent

import mu.KotlinLogging

class RegisteredUserReadModelQuery(var aggregateId: UUID) : Query

@Component
class RegisteredUserReadModelEventSourceRepository(eventStore: EventStore) :
    EventSourcingRepository<RegisteredUserReadModel>(builder(RegisteredUserReadModel::class.java).eventStore(eventStore))


class RegisteredUserReadModel : ReadModel {

    @AggregateIdentifier
    var aggregateId: UUID? = null;
    var email: String? = null;
    var name: String? = null;
    var vorname: String? = null;


    @EventSourcingHandler
    fun on(event: UserRegisteredEvent) {
        //TODO process fields

        aggregateId = event.aggregateId
        email = event.email
        name = event.name
        vorname = event.vorname

    }

}
