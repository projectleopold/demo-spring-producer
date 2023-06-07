package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        url $(
                producer('/api/datum/single-data-id'),
                consumer(regex('/api/datum/[a-zA-Z0-9-_]+'))
        )
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: fromRequest().path(2),
                value: $('single-data-value')
        )
    }
}
