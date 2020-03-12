package ai.h2o.sparkling.ml.params

import org.apache.spark.ml.param.{BooleanParam, Param}

trait H2OMOJOPipelineParams extends H2OMOJOAlgoSharedParams {
  
  protected final val removeModel: Param[Boolean] = new BooleanParam(this, "removeModel", "The modelling part is removed from MOJO pipeline.")

  setDefault(
    removeModel -> false
  )

  //
  // Getters
  //
  def getRemoveModel(): Boolean = $(removeModel)

  //
  // Setters
  //
  def setRemoveModel(value: Boolean): this.type = set(removeModel, value)

}
