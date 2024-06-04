package de.nebulit.registeruser.internal

import org.springframework.stereotype.Component
import de.nebulit.domain.UserAggregate
import java.util.UUID
import mu.KotlinLogging
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EventStore
import java.util.concurrent.Callable

@Component
class UserAggregateEventSourceRepository(eventStore: EventStore): EventSourcingRepository<UserAggregate>(
    builder(
    UserAggregate::class.java).eventStore(eventStore))


@Component
class RegisterUserCommandCommandHandler(
    private var aggregateRepository: EventSourcingRepository<UserAggregate>,
) {

    var logger = KotlinLogging.logger {}

    @CommandHandler
    fun handle(command: RegisterUserCommand) {

        aggregateRepository.loadOrCreate(
            command.aggregateId.toString(),
            {
                UserAggregate().apply {
                    aggregateId = command.aggregateId
                }
            }
        ).execute {
            it.registerUser(command.name, command.vorname, command.email)
        }


    }

}
