# infantium.addSoundEvent()

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

	infantium.addSoundEvent( event_id, type, associated_text, language, imprecise_sound_volume, duration )


##### event_id ~^(required)^~
_[String][api.type.String]._ Unique event identifier for this scene. It will be used when referring to the event later on.

##### type ~^(optional)^~
_[String][api.type.String]._ The type of the Event. Allowed values for this version are "sound" and "missed_opportunity". "" if not used.

##### associated_text ~^(optional)^~
_[String][api.type.String]._ Text read/sung in the Sound. "" if empty.

##### language ~^(optional)^~
_[String][api.type.String]._ Language of the previous text, written in *language* + *country* code. Language follows the [ISO 639-1](http://en.wikipedia.org/wiki/ISO_639-1), whereas the country follows the [ISO 3166-1 alpha-2](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). "" if empty.

##### imprecise_sound_volume ~^(optional)^~
_[Number][api.type.Number]._ The approximate volume of the Sound. -1.0 if not used.

##### duration ~^(optional)^~
_[Number][api.type.Number]._ The duration of the Sound in milliseconds. -1 if not used.


## Extra Info

More info in the [Events](http://infantium-sdk-docs.readthedocs.org/en/latest/advanced_guides/events.html) advanced guide of the official docs.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.addSoundEvent("lion_name_sound", "female_voice", "Lion", "en-US", -1.0, -1)
infantium.addSoundEvent("orange_name_sound", "voice", "Naranja", "es-es", 0.7, 1000)
infantium.addSoundEvent("knees_and_toes_song", "song", "", "", -1.0, -1)
``````
