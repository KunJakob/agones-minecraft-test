/**
* sdk.proto
* No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
*
* The version of the OpenAPI document: version not set
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package io.github.kunjakob.agonesclient.models

import io.github.kunjakob.agonesclient.models.GameServerObjectMeta
import io.github.kunjakob.agonesclient.models.GameServerSpec
import io.github.kunjakob.agonesclient.models.GameServerStatus

import com.squareup.moshi.Json
/**
 * A GameServer Custom Resource Definition object We will only export those resources that make the most sense. Can always expand to more as needed.
 * @param objectMeta 
 * @param spec 
 * @param status 
 */

data class SdkGameServer (
    @Json(name = "object_meta")
    var objectMeta: GameServerObjectMeta? = null,
    @Json(name = "spec")
    var spec: GameServerSpec? = null,
    @Json(name = "status")
    var status: GameServerStatus? = null
)
