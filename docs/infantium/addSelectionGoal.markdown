# infantium.addSelectionGoal()

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

Adds one Selection Goal for the current scene.

## Syntax

	infantium.addSelectionGoal( goal_id, time_limit, auto_eval, instructions, n_correct_choices, n_incorrect_choices, unique_solution, needed_action )

##### goal_id ~^(required)^~
_[String][api.type.String]._ Unique goal identifier for this scene. It will be used when referring to the goal later on.

##### time_limit ~^(optional)^~
_[Number][api.type.Number]._ The limit of time in milliseconds the kid can interact with this goal. -1 if not used.

##### auto_eval ~^(optional)^~
_[Boolean][api.type.Boolean]._ Indicates that a child action automatically triggers evaluation. true if not used.

##### instructions ~^(optional)^~
_[String][api.type.String]._ If there are instructions for the current scene, they can be defined as an element. Here there is the link to that element, it's id. "" if not used.

##### n_correct_choices ~^(optional)^~
_[Number][api.type.Number]._ Number of correct choices from which to choose. -1 if not used.

##### n_incorrect_choices ~^(optional)^~
_[Number][api.type.Number]._ Number of incorrect choices available to choose. -1 if not used.

##### unique_solution ~^(optional)^~
_[Boolean][api.type.Boolean]._ False if the kid can choose different correct solutions. True if not used.

##### needed_action ~^(optional)^~
_[String][api.type.String]._ Which action triggers the selection. Choices can be "tap", "double_tap", "drag", among others. "" if not used.


## Extra Info

More info in the [Selection Goals](http://infantium-sdk-docs.readthedocs.org/en/latest/advanced_guides/goals.html#selection-goals) advanced guide of the official docs.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.addSelectionGoal("selection_goal_1", -1, true, "", 1, -1, true, "double_tap")
``````
