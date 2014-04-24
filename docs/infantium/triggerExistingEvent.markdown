# infantium.triggerExistingEvent()

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

Registers an the occurrence of an Event in the current scene.

## Syntax

	infantium.triggerExistingEvent( event_id, triggered_by )

##### event_id ~^(required)^~
_[String][api.type.String]._ The ID of the Event previously defined.

##### triggered_by ~^(optional)^~
_[String][api.type.String]._ What triggered the Event. Can be "tap", "drag", "double_tap", "timer", "random", etc. "" if not used.


## Extra Info

More info in the [Events](http://infantium-sdk-docs.readthedocs.org/en/latest/advanced_guides/events.html) advanced guide of the official docs.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.triggerExistingEvent("lion_name_sound", "tap")
infantium.triggerExistingEvent("knees_and_toes_song", "")
``````
