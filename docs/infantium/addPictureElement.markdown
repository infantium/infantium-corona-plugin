# infantium.addPictureElement()

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

Adds a Picture Element on the screen for the current scene.

## Syntax

	infantium.addPictureElement( element_id, width, height, movement )


##### element_id ~^(required)^~
_[String][api.type.String]._ Unique element identifier for this scene. It will be used when referring to the element.

##### width ~^(optional)^~
_[Number][api.type.Number]._ The width of the element. -1 if not used.

##### height ~^(optional)^~
_[Number][api.type.Number]._ The height of the element. -1 if not used.

##### movement ~^(optional)^~
_[String][api.type.String]._ The type of movement of the element. "" if not used. Can take several values, it is "static" by default. More values in the official docs.


## Extra Info

More info in the [Picture Elements](http://infantium-sdk-docs.readthedocs.org/en/latest/advanced_guides/elements.html#picture-elements) advanced guide of the official docs.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.addPictureElement("picture_element_1", 150, 50, "")
``````
