# infantium.addTappingGoal()

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

Adds one Tapping Goal for the current scene.

## Syntax

	infantium.addTappingGoal( goal_id, time_limit, auto_eval, instructions, element_to_tap )

##### goal_id ~^(required)^~
_[String][api.type.String]._ Unique goal identifier for this scene. It will be used when referring to the goal later on.

##### time_limit ~^(optional)^~
_[Number][api.type.Number]._ The limit of time in milliseconds the kid can interact with this goal. -1 if not used.

##### auto_eval ~^(optional)^~
_[Boolean][api.type.Boolean]._ Indicates that a child action automatically triggers evaluation. true if not used.

##### instructions ~^(optional)^~
_[String][api.type.String]._ If there are instructions for the current scene, they can be defined as an element. Here there is the link to that element, it's id. "" if not used.

##### element_to_tap ~^(required)^~
_[String][api.type.String]._ Element which the kid should interact with. It can be the keyword "ALL" which references all the elements on the screen.


## Extra Info

More info in the [Tapping Goals](http://infantium-sdk-docs.readthedocs.org/en/latest/advanced_guides/goals.html#tapping-goals) advanced guide of the official docs.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.addTappingGoal("tapping_all_goal_1", -1, true, "", "ALL")
``````
