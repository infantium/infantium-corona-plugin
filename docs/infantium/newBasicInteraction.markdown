# infantium.newBasicInteraction()

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

Registers an interaction of the kid with the app.

## Syntax

	infantium.newBasicInteraction( interaction_t, object_type, goal_type, lifetime, n_concurrent_oks, n_concurrent_kos )

##### interaction_t ~^(optional)^~
_[String][api.type.String]._ The type of the interaction: "success", "error", "none".

##### object_type ~^(optional)^~
_[String][api.type.String]._ Relates this interaction to an element. This parameter should be it's id. "" if not used.

##### goal_type ~^(required)^~
_[String][api.type.String]._ Relates this interaction to a goal. This parameter should be it's id.

##### lifetime ~^(optional)^~
_[Number][api.type.Number]._ Amount of time in milliseconds the kid had available to make this interaction. -1 if not used.

##### n_concurrent_oks ~^(optional)^~
_[Number][api.type.Number]._ Number of available correct answers when the interaction happened. -1 if not used.

##### n_concurrent_kos ~^(optional)^~
_[Number][api.type.Number]._ Number of available incorrect answers when the interaction happened. -1 if not used.


## Extra Info

More info in the [Basic Interactions](http://infantium-sdk-docs.readthedocs.org/en/latest/advanced_guides/basic_interaction.html) advanced guide of the official docs.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.newBasicInteraction("success", "", "goal_1", -1, -1, -1)
infantium.newBasicInteraction("success", "text_element_1", "goal_2", -1, -1, -1);
infantium.newBasicInteraction("error", "text_element_1", "goal_1", -1, -1, -1);
infantium.newBasicInteraction("success", "", "matching_goal_1", 60000, 2, 5);
``````
