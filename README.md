# io.github.jakob.AgonesClient - Kotlin client library for sdk.proto

## Requires

* Kotlin 1.3.41
* Gradle 4.9

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://localhost*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*SDKApi* | [**allocate**](docs/SDKApi.md#allocate) | **POST** /allocate | Call to self Allocation the GameServer
*SDKApi* | [**getGameServer**](docs/SDKApi.md#getgameserver) | **GET** /gameserver | Retrieve the current GameServer data
*SDKApi* | [**health**](docs/SDKApi.md#health) | **POST** /health | Send a Empty every d Duration to declare that this GameSever is healthy
*SDKApi* | [**ready**](docs/SDKApi.md#ready) | **POST** /ready | Call when the GameServer is ready
*SDKApi* | [**reserve**](docs/SDKApi.md#reserve) | **POST** /reserve | Marks the GameServer as the Reserved state for Duration
*SDKApi* | [**setAnnotation**](docs/SDKApi.md#setannotation) | **PUT** /metadata/annotation | Apply a Annotation to the backing GameServer metadata
*SDKApi* | [**setLabel**](docs/SDKApi.md#setlabel) | **PUT** /metadata/label | Apply a Label to the backing GameServer metadata
*SDKApi* | [**shutdown**](docs/SDKApi.md#shutdown) | **POST** /shutdown | Call when the GameServer is shutting down
*SDKApi* | [**watchGameServer**](docs/SDKApi.md#watchgameserver) | **GET** /watch/gameserver | Send GameServer details whenever the GameServer is updated


<a name="documentation-for-models"></a>
## Documentation for Models

 - [io.github.jakob.AgonesClient.models.GameServerObjectMeta](docs/GameServerObjectMeta.md)
 - [io.github.jakob.AgonesClient.models.GameServerSpec](docs/GameServerSpec.md)
 - [io.github.jakob.AgonesClient.models.GameServerStatus](docs/GameServerStatus.md)
 - [io.github.jakob.AgonesClient.models.ProtobufAny](docs/ProtobufAny.md)
 - [io.github.jakob.AgonesClient.models.RuntimeStreamError](docs/RuntimeStreamError.md)
 - [io.github.jakob.AgonesClient.models.SdkDuration](docs/SdkDuration.md)
 - [io.github.jakob.AgonesClient.models.SdkGameServer](docs/SdkGameServer.md)
 - [io.github.jakob.AgonesClient.models.SdkKeyValue](docs/SdkKeyValue.md)
 - [io.github.jakob.AgonesClient.models.SpecHealth](docs/SpecHealth.md)
 - [io.github.jakob.AgonesClient.models.StatusPlayerStatus](docs/StatusPlayerStatus.md)
 - [io.github.jakob.AgonesClient.models.StatusPort](docs/StatusPort.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
