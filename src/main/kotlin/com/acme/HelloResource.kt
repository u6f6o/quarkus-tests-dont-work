package com.acme

import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@ApplicationScoped
@Path("/api/hello")
class HelloResource {

    @GET
    suspend fun hello(): String {
        return "hello"
    }
}