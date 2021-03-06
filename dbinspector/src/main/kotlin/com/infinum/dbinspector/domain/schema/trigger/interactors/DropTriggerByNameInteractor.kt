package com.infinum.dbinspector.domain.schema.trigger.interactors

import com.infinum.dbinspector.data.Sources
import com.infinum.dbinspector.data.models.local.QueryResult
import com.infinum.dbinspector.domain.Interactors
import com.infinum.dbinspector.domain.shared.models.Query

internal class DropTriggerByNameInteractor(
    val source: Sources.Local.Schema
) : Interactors.DropTriggerByName {

    override suspend fun invoke(input: Query): QueryResult =
        source.dropTriggerByName(input)
}
