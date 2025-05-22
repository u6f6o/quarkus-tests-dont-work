package com.acme

import io.quarkus.test.junit.QuarkusIntegrationTest
import io.quarkus.test.junit.QuarkusTest
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@QuarkusTest
@TestMethodOrder(OrderAnnotation::class)
class ActuatorTest {

    @Test
    @Order(1)
    @DisplayName("Should respond to health check")
    fun healthCheck() {
        When {
            get("internal/health")
        } Then {
            statusCode(200)
            body("status", equalTo("UP"))
        }
    }

    @Test
    @Order(2)
    @DisplayName("Should respond to readiness check")
    fun readinessCheck() {
        When {
            get("internal/health/readiness")
        } Then {
            statusCode(200)
            body("status", equalTo("UP"))
        }
    }

    @Test
    @Order(3)
    @DisplayName("Should expose OAS3 documentation")
    fun serviceDocs() {
        When {
            get("/api/docs")
        } Then {
            statusCode(200)
            contentType("application/yaml;charset=UTF-8")
            body(containsString("openapi"))
        }
    }
}
