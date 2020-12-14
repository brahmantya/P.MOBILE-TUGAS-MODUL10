package com.infinum.dbinspector.ui.schema.triggers

import com.infinum.dbinspector.domain.UseCases
import com.infinum.dbinspector.domain.shared.models.Query
import com.infinum.dbinspector.domain.shared.models.Statements
import com.infinum.dbinspector.ui.schema.shared.SchemaDataSource

internal class TriggersDataSource(
    databasePath: String,
    statement: String,
    private val getSchema: UseCases.GetTriggers
) : SchemaDataSource() {

    override var query: Query = Query(
        databasePath = databasePath,
        statement = statement
    )

    override var argument: String?
        get() {
            return ""
        }
        set(value) {
            query = query.copy(
                statement = Statements.Schema.triggers(query = value),
                page = 1
            )
            invalidate()
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        val page = getSchema(query)
        query = query.copy(page = page.nextPage)
        return LoadResult.Page(
            data = page.fields,
            prevKey = null,
            nextKey = page.nextPage,
            itemsAfter = page.afterCount
        )
    }
}
