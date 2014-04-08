# infantium.createGameplay()

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

Represents the start of a game session by a kid. During this session many data will be sent, so the gameplay will only be closed when the kid stops playing. More info and examples in [the official docs](http://docs.infantium.com). Can be called without a subcontent_uuid, which allows the user to call [setSubContentUUID][plugin.infantium.setSubContentUUID] later in the game.

## Syntax

	infantium.createGameplay(  )
	infantium.createGameplay( subcontent_uuid )

##### subcontent_uuid ~^(optional)^~
_[String][api.type.String]._ Private UUID of the subcontent being played.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.createGameplay("00000000000000000000000000000000")
``````
