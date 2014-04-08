# infantium.sendGameRawdata()

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

Send the game data to the server.

## Syntax

	infantium.sendGameRawdata(  )


## Extra Info

This method restarts the data in the scene, so it should be called at the end of that scene. After this, elements and goals should be introduced again.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.sendGameRawdata()
``````
