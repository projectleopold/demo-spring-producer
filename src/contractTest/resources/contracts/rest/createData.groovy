package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method POST()
        url '/api/datum'
        headers {
            contentType applicationJson()
        }
        body(
                id: $('new-data-id'),
                value: $('new-data-value')
        )
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: $('new-data-id'),
                value: $('new-data-value')
        )
    }
}
