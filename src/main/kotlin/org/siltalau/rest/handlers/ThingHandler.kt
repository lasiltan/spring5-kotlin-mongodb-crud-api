package org.siltalau.rest.handlers

import org.siltalau.rest.model.Thing
import org.siltalau.rest.repository.ThingRepo
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.net.URI

@Component
class ThingHandler(val thingRepo: ThingRepo) {

    fun BodyBuilder.json(): BodyBuilder = this.header("Content-Type", "application/json")

    fun Mono<Thing>.okOrNotFoundResponse(): Mono<ServerResponse> = this.hasElement().flatMap {
        if (it) ok().json().body(this) else notFound().build()
    }

    fun Flux<Thing>.okResponse(): Mono<ServerResponse> =
            ok().json().body(this)

    fun findAll(req: ServerRequest): Mono<ServerResponse> =
            thingRepo.findAll().okResponse()

    fun save(req: ServerRequest): Mono<ServerResponse> =
            req.bodyToMono<Thing>().flatMap {
                thingRepo.save(it).flatMap {
                    created(URI.create("/v1/things/${it.id}")).body(it.toMono())
                }

            }

    fun findOne(req: ServerRequest): Mono<ServerResponse> =
            thingRepo.findById(req.pathVariable("id")).okOrNotFoundResponse()


    fun delete(req: ServerRequest): Mono<ServerResponse> =
            thingRepo.deleteById(req.pathVariable("id")).flatMap {
                ok().build()
            }

}
