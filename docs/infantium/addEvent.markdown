# infantium.addEvent()

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

Registers an Event for the current scene. Check the function [infantium.triggerExistingEvent()][plugin.infantium.triggerExistingEvent] for more info about triggering the event.

## Syntax

	infantium.addEvent( event_id, type )


##### event_id ~^(required)^~
_[String][api.type.String]._ Unique event identifier for this scene. It will be used when referring to the event later on.

##### type ~^(optional)^~
_[String][api.type.String]._ The type of the Event. Allowed values for this version are "sound" and "missed_opportunity". "" if not used.


## Extra Info

More info in the [Events](http://infantium-sdk-docs.readthedocs.org/en/latest/advanced_guides/events.html) advanced guide of the official docs.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.addEvent("balloon_flies_away", "missed_opportunity")
``````
