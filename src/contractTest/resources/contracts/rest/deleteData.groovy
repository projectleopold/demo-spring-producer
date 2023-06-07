package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method DELETE()
        url $(
                producer('/api/datum/data-id'),
                consumer(regex('/api/datum/[a-zA-Z0-9-_]+'))
        )
    }
    response {
        status OK()
    }
}
