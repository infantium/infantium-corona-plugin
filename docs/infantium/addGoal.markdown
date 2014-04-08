# infantium.addGoal()

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

Adds one Goal for the current scene.

## Syntax

	infantium.addGoal( goal_id, time_limit, auto_eval, instructions )

##### goal_id ~^(required)^~
_[String][api.type.String]._ Unique goal identifier for this scene. It will be used when referring to the goal later on.

##### time_limit ~^(optional)^~
_[Number][api.type.Number]._ The limit of time in milliseconds the kid can interact with this goal. -1 if not used.

##### auto_eval ~^(optional)^~
_[Boolean][api.type.Boolean]._ Indicates that a child action automatically triggers evaluation. true if not used.

##### instructions ~^(optional)^~
_[String][api.type.String]._ If there are instructions for the current scene, they can be defined as an element. Here there is the link to that element, it's id. "" if not used.


## Extra Info

More info in the [Goals](http://infantium-sdk-docs.readthedocs.org/en/latest/advanced_guides/goals.html) advanced guide of the official docs.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.addGoal("goal_1", -1, true, "text_element_2")
infantium.addGoal("goal_2", -1, true, "")
``````
