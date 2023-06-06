package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method DELETE()
        url '/api/datum/data-id'
    }
    response {
        status OK()
    }
}
