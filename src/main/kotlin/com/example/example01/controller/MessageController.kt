package com.example.example01.controller

import com.example.example01.service.MessageService
import org.springframework.web.bind.annotation.*

data class Message(val id: String?, val text: String)

@RestController
class MessageController (val service: MessageService) {
//    @GetMapping("/")
//    fun index(@RequestParam("name") name: String) = "Hello, $name!"
//
//
//    @GetMapping("/getList")
//    fun index() = listOf(
//            Message("1", "Hello!"),
//            Message("2", "Bonjour!"),
//            Message("3", "Privet!"),
//    )
    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> =
            service.findMessageById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        service.save(message)
    }


}