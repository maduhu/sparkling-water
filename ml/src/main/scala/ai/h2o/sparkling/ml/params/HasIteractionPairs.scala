/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.h2o.sparkling.ml.params

import hex.StringPair

trait HasInteractionPairs extends H2OAlgoParamsBase {
  private val interactionPairs = new NullableStringPairArrayParam(
    this,
    "interactionPairs",
    "A list of pairwise (first order) column interactions.")

  setDefault(interactionPairs -> null)

  def getInteractionPairs(): Array[(String, String)] = $(interactionPairs)

  def setInteractionPairs(value: Array[(String, String)]): this.type = set(interactionPairs -> value)

  override private[sparkling] def getH2OAlgorithmParams(): Map[String, Any] = {
    val interactionPairs = getInteractionPairs()
    val interactionPairsMap = if (interactionPairs == null) {
      null
    } else {
      interactionPairs.map(pair => new StringPair(pair._1, pair._2).toJsonString)
    }
    println(interactionPairsMap)
    super.getH2OAlgorithmParams() ++ Map("interaction_pairs" -> interactionPairsMap)
  }

  override private[sparkling] def getSWtoH2OParamNameMap(): Map[String, String] = {
    super.getSWtoH2OParamNameMap() ++ Map("interactionPairs" -> "interaction_pairs")
  }
}
