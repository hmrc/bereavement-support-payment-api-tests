/*
 * Copyright 2024 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.api.responses.individuals.income.sa.trusts

import play.api.libs.json.{JsValue, Json}
import uk.gov.hmrc.test.api.models.UseCaseResponse
import uk.gov.hmrc.test.api.responses.CommonResponses

object HOV1 extends CommonResponses {

  val status = OK

  def getFullResponse(matchId: String) =
    UseCaseResponse(getExpectedResponse(matchId), status)

  def getExpectedResponse(matchId: String): JsValue = Json.parse(s"""{
      |    "_links": {
      |        "self": {
      |            "href": "/individuals/income/sa/trusts?matchId=$matchId&fromTaxYear=2019-20&toTaxYear=2021-22"
      |        }
      |    },
      |    "selfAssessment": {
      |        "taxReturns": [
      |            {
      |                "taxYear": "2020-21",
      |                "trusts": [
      |                    {
      |                        "utr": "0987654321",
      |                        "trustIncome": 365.2
      |                    }
      |                ]
      |            },
      |            {
      |                "taxYear": "2019-20",
      |                "trusts": [
      |                    {
      |                        "utr": "0987654321",
      |                        "trustIncome": 123.2
      |                    }
      |                ]
      |            }
      |        ]
      |    }
      |}""".stripMargin)
}
