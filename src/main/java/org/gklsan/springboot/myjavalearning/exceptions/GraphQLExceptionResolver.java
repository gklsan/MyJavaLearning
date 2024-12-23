package org.gklsan.springboot.myjavalearning.exceptions;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class GraphQLExceptionResolver extends DataFetcherExceptionResolverAdapter {

  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
    if(ex instanceof StudentNotFoundException) {
      return GraphqlErrorBuilder
                 .newError(env)
                 .message(ex.getMessage())
                 .errorType(ErrorClassification.errorClassification("Not Found"))
                 .path(env.getExecutionStepInfo().getPath())
                 .build();
    }
    return null;
  }
}
