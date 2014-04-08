# infantium.setContentAppUUID()

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

This method is used to identify the App against the server. To get this UUID you must first contact Infantium.

## Syntax

	infantium.setContentAppUUID( contentapp_uuid )

##### contentapp_uuid ~^(required)^~
_[String][api.type.String]._ Private UUID of the App.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.setContentAppUUID("00000000000000000000000000000000")
``````
