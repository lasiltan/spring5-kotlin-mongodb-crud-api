package org.siltalau.rest

import org.siltalau.rest.handlers.ThingHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class AppRoutes(val thingHandler: ThingHandler) {

    @Bean
    fun api() = router {
        "/v1".nest {
            "/things".nest {
                GET("/", thingHandler::findAll)
                POST("/", thingHandler::save)
                GET("/{id}", thingHandler::findOne)
                PUT("/{id}", thingHandler::save)
                DELETE("/{id}", thingHandler::delete)
            }
        }
    }
}