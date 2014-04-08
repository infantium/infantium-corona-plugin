# infantium.setSubContentUUID()

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

Identify which subcontent the kid is playing in the current moment.

## Syntax

	infantium.setSubContentUUID( subcontent_uuid )

##### subcontent_uuid ~^(required)^~
_[String][api.type.String]._ Private UUID of the subcontent being played.


## Extra Info

Not all the apps will need to use this function.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.setSubContentUUID("00000000000000000000000000000000")
``````
