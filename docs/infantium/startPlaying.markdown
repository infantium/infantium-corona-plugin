# infantium.startPlaying()

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

Triggers the timers on the current scene. To be called when the kid can actually start interacting with the screen (after animations, or preloads, etc).

## Syntax

	infantium.startPlaying(  )


## Extra Info

In the [walkthrough of the official docs](http://infantium-sdk-docs.readthedocs.org/en/latest/getting_started/game_walkthrough.html) you can find further info about this function.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.startPlaying()
``````
