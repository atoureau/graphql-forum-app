package com.bgeneral.graphql.forum.config.instrumentation;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.execution.instrumentation.SimplePerformantInstrumentation;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionParameters;
import graphql.execution.instrumentation.InstrumentationState;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

public class LoggingInstrumentation extends SimplePerformantInstrumentation {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInstrumentation.class);

    @NonNull
    @Override
    public ExecutionInput instrumentExecutionInput(
            ExecutionInput executionInput,
            InstrumentationExecutionParameters parameters,
            InstrumentationState state
    ) {
        logger.info("GraphQL Request: {}", executionInput.getQuery());
        logger.info("GraphQL Request Variables: {}", executionInput.getVariables());
        return executionInput;
    }

    @NonNull
    @Override
    public CompletableFuture<ExecutionResult> instrumentExecutionResult(
            ExecutionResult executionResult,
            InstrumentationExecutionParameters parameters,
            InstrumentationState state
    ) {
        logger.info("GraphQL Response: {}", executionResult.toSpecification());
        return CompletableFuture.completedFuture(executionResult);
    }
}