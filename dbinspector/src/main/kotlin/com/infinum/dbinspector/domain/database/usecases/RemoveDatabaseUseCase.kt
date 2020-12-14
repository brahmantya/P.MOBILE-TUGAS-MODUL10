package com.infinum.dbinspector.domain.database.usecases

import com.infinum.dbinspector.domain.Repositories
import com.infinum.dbinspector.domain.UseCases
import com.infinum.dbinspector.domain.database.models.DatabaseDescriptor
import com.infinum.dbinspector.domain.database.models.Operation

internal class RemoveDatabaseUseCase(
    private val databaseRepository: Repositories.Database
) : UseCases.RemoveDatabase {

    override suspend fun invoke(input: Operation): List<DatabaseDescriptor> =
        databaseRepository.remove(input)
}