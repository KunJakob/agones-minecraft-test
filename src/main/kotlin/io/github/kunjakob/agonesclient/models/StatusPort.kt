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


import com.squareup.moshi.Json
/**
 * 
 * @param name 
 * @param port 
 */

data class StatusPort (
    @Json(name = "name")
    var name: kotlin.String? = null,
    @Json(name = "port")
    var port: kotlin.Int? = null
)
