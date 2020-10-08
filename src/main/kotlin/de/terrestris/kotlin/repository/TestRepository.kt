package de.terrestris.kotlin.repository

import de.terrestris.kotlin.model.Test
import de.terrestris.shoguncore.repository.BaseCrudRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : BaseCrudRepository<Test, Long>, JpaSpecificationExecutor<Test>