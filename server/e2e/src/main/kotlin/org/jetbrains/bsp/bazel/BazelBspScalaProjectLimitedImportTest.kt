package org.jetbrains.bsp.bazel

import ch.epfl.scala.bsp4j.WorkspaceBuildTargetsResult
import org.apache.logging.log4j.LogManager
import org.jetbrains.bsp.bazel.base.BazelBspTestBaseScenario
import org.jetbrains.bsp.bazel.base.BazelBspTestScenarioStep

object BazelBspScalaProjectLimitedImportTest : BazelBspTestBaseScenario() {
  private val log = LogManager.getLogger(BazelBspScalaProjectLimitedImportTest::class.java)
  private val testClient = createTestkitClient()
  private val testClientClasspathReceiver = createTestkitClient(jvmClasspathReceiver = true)

  @JvmStatic
  fun main(args: Array<String>) =
    try {
      executeScenario()
    } catch (t: Throwable) {
      testClient.client.logMessageNotifications.forEach {
        log.info(it.message)
      }
      throw t
    }



  override fun expectedWorkspaceBuildTargetsResult(): WorkspaceBuildTargetsResult {
    println("expectedWorkspaceBuildTargetsResult")
    return WorkspaceBuildTargetsResult(emptyList())
  }

  override fun scenarioSteps(): List<BazelBspTestScenarioStep> {
    print("hello scenarioSteps")
    return listOf()
  }

}
