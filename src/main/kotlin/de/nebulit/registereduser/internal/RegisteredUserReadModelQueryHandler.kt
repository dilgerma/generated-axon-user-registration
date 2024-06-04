package de.nebulit.registereduser.internal

import de.nebulit.common.QueryHandler
import org.springframework.stereotype.Component
import de.nebulit.registereduser.RegisteredUserReadModel
import de.nebulit.registereduser.RegisteredUserReadModelQuery
import org.axonframework.eventsourcing.EventSourcingRepository
import java.util.UUID
import mu.KotlinLogging


@Component
class RegisteredUserReadModelQueryHandler(
    val eventSourcedRepository: EventSourcingRepository<RegisteredUserReadModel>
) :
    QueryHandler<RegisteredUserReadModelQuery, RegisteredUserReadModel> {

        @org.axonframework.queryhandling.QueryHandler
    override fun handleQuery(query: RegisteredUserReadModelQuery): RegisteredUserReadModel {
           var result =  eventSourcedRepository.load(query.aggregateId.toString())
            return result.wrappedAggregate.aggregateRoot
        }



}

