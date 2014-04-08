# infantium.setDeviceInfo()

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

Set the size in pixels of the device executing your App.

## Syntax

	infantium.setDeviceInfo( width, height )

##### width ~^(required)^~
_[Number][api.type.Number]._ Width in pixels of the device.


##### height ~^(required)^~
_[Number][api.type.Number]._ Height in pixels of the device.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````luad
local infantium = require "plugin.infantium"

infantium.setDeviceInfo(500, 800)
``````
