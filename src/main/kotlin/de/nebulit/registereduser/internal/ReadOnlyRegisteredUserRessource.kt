package de.nebulit.registereduser.internal

import de.nebulit.registereduser.RegisteredUserReadModel
import de.nebulit.registereduser.RegisteredUserReadModelQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import mu.KotlinLogging
import org.axonframework.queryhandling.QueryGateway
import java.util.UUID



@RestController
class RegistereduserRessource(
    private var queryGateway: QueryGateway
    ) {

    var logger = KotlinLogging.logger {}

    @CrossOrigin
    @GetMapping("/registereduser")
    fun findReadModel(@RequestParam aggregateId:UUID):RegisteredUserReadModel {
     return queryGateway.query(RegisteredUserReadModelQuery(aggregateId), RegisteredUserReadModel::class.java).get()    }
      

}
