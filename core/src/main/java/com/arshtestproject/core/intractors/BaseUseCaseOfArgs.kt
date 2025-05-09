package com.arshtestproject.core.intractors

interface BaseUseCase<in Parameter, out Result> {
    suspend operator fun invoke(params: Parameter): Result
}

interface BaseUseCaseOf<out Result> {
    suspend operator fun invoke(): Result
}