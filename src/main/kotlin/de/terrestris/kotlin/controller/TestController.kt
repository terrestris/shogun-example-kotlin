package de.terrestris.kotlin.controller

import de.terrestris.kotlin.config.properties.TestProperties
import de.terrestris.kotlin.model.Test
import de.terrestris.kotlin.repository.TestRepository
import de.terrestris.shoguncore.enumeration.LayerType
import de.terrestris.shoguncore.model.Layer
import de.terrestris.shoguncore.repository.LayerRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/test")
class TestController(
    private val testRepository: TestRepository,
    private val layerRepository: LayerRepository
) {
    @RequestMapping(value = ["/add25/{param}"], method = [RequestMethod.GET])
    fun add25(@PathVariable param: Int): ResponseEntity<Int> {
        return ResponseEntity.ok(25 + param)
    }

    @RequestMapping(value = ["get-config"], method = [RequestMethod.GET])
    fun getConfig(conf: TestProperties): ResponseEntity<String> {
        return ResponseEntity.ok(conf.someConfig)
    }

    @RequestMapping(value = ["/create-persisted/{name}"], method = [RequestMethod.GET])
    fun createPersisted(@PathVariable name: String): ResponseEntity<Test> {
        val layer = Layer()
        layer.name = "layer of $name"
        layer.sourceConfig = HashMap<String, Any>()
        layer.type = LayerType.WMS
        layerRepository.save(layer)

        val test = Test(name, layer)
        testRepository.save(test)

        return ResponseEntity.ok(test)
    }

    @RequestMapping(value = ["/get-persisted"], method = [RequestMethod.GET])
    fun getPersisted(): ResponseEntity<MutableIterable<Test>> {
        return ResponseEntity.ok(testRepository.findAll())
    }
}