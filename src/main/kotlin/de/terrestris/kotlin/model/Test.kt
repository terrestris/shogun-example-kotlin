package de.terrestris.kotlin.model

import de.terrestris.shoguncore.model.BaseEntity
import de.terrestris.shoguncore.model.Layer
import lombok.*
import javax.persistence.*

@Entity(name = "test")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
class Test(
    @Column
    val name: String,

    @OneToOne
    val layer: Layer
) : BaseEntity()