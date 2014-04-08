# infantium.setDeveloperCredentials()

> --------------------- ------------------------------------------------------------------------------------------
> __Type__              [function][api.type.function]
> __Library__           [infantium.*][plugin.infantium]
> __Return value__      [String][api.type.String]
> __Revision__          [REVISION_LABEL](REVISION_URL)
> __Keywords__          
> __Sample code__       
> __See also__          
> --------------------- ------------------------------------------------------------------------------------------


## Overview

Identify the developer against the server. To get the private keys you need to contact Infantium first.

## Syntax

	infantium.setDeveloperCredentials( api_username, api_key )

##### api_username ~^(required)^~
_[String][api.type.String]._ Private developer api_username, provided by Infantium.


##### api_key ~^(required)^~
_[String][api.type.String]._ Private developer api_key, provided by Infantium.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.setDeveloperCredentials("username","0000000000000000000000000000000000000000")
``````
