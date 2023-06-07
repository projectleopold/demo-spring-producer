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
                id: $(
                        producer('new-data-id'),
                        consumer(nonEmpty())
                ),
                value: $(
                        producer('new-data-value'),
                        consumer(nonEmpty())
                )
        )
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: fromRequest().body('$.id'),
                value: fromRequest().body('$.value')
        )
    }
}
