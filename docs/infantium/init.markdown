# infantium.init()

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

This method is used to initialize the Plugin with some configuration parameters.

## Syntax

	infantium.init(  )
	infantium.init( server, debug )

##### server ~^(optional)^~
_[String][api.type.String]._ Either "api" or "beta", that is for production or development environments.

##### debug ~^(optional)^~
_[Boolean][api.type.Boolean]._ Configures the logs printed in the Android Log.


## Extra Info

Can be called without arguments, which default to "beta" and true.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.init("beta", true)
``````
