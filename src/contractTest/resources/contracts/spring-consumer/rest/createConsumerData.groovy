import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method POST()
        url '/api/datum'
        headers {
            contentType applicationJson()
        }
        body(
                id: $(regex('id-.+')),
                data: $(regex('value-.+'))
        )
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: fromRequest().body('$.id'),
                data: fromRequest().body('$.data')
        )
    }
}
