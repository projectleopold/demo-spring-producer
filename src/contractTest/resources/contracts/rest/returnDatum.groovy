package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        url '/api/datum'
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body([
                [
                        id   : $('first-data-id'),
                        value: $('first-data-value')
                ],
                [
                        id   : $('second-data-id'),
                        value: $('second-data-value')
                ]
        ])
    }
}
