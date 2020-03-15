package ai.h2o.sparkling.ml.params

import org.apache.spark.ml.param.{BooleanParam, Param, StringArrayParam}
import org.apache.spark.sql.types.StructType

trait H2OMOJOPipelineParams extends H2OMOJOAlgoSharedParams {
  
  protected final val removeModel: BooleanParam = new BooleanParam(
    this,
       "removeModel",
       "The modelling part is removed from MOJO pipeline.")

  // private parameter used to store MOJO output columns
  protected final val outputCols: StringArrayParam = new StringArrayParam(
    this,
      "outputCols",
      "Name of output columns produced by the MOJO.")

  protected final val inputSchema: StructTypeParam = new StructTypeParam(
    this,
       "inputSchema",
       "Expected input schema by the MOJO model.")

  protected final val outputSchema: StructTypeParam = new StructTypeParam(
    this,
      "outputSchema",
      "Exposed output schema by the MOJO model.")

  protected final val expandNamedMojoOutputColumns: BooleanParam = new BooleanParam(
    this,
    "expandNamedMojoOutputColumns",
    "Expand output named columns."
  )
  
  setDefault(
    removeModel -> false,
    expandNamedMojoOutputColumns -> false
  )

  //
  // Getters
  //
  def getRemoveModel(): Boolean = $(removeModel)

  def getOutputCols(): Array[String] = $(outputCols)

  def getInputSchema(): StructType = $(inputSchema)

  def getOutputSchema(): StructType = $(outputSchema)

  def getExpandNamedMojoOutputColumns(): Boolean = $(expandNamedMojoOutputColumns)
}
