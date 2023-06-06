package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        url '/api/datum/single-data-id'
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: $('single-data-id'),
                value: $('single-data-value')
        )
    }
}
